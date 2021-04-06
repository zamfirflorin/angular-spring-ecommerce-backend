package com.rawdebun.ecommerce.config;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.metamodel.EntityType;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurer;
import org.springframework.http.HttpMethod;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.rawdebun.ecommerce.entity.Employee;
import com.rawdebun.ecommerce.entity.Product;
import com.rawdebun.ecommerce.entity.ProductCategory;

/**
 * @author zamfi
 *
 */
@Configuration
public class MyDataRestConfig implements RepositoryRestConfigurer {

	@Autowired
	private EntityManager entityManager;
	
	@Autowired
	public MyDataRestConfig(EntityManager theEntityManager) {
		this.entityManager = theEntityManager;
	}
	
	@Transactional
    @DeleteMapping(value = "/employees/{id}")
    public void deleteEmployee(@PathVariable Long id) {

        Employee emp = entityManager.find(Employee.class, id);
        //Call remove method to remove the entity
        if(emp != null){
        	entityManager.remove(emp);
        }
}

	@Override
	public void configureRepositoryRestConfiguration(RepositoryRestConfiguration config) {

		HttpMethod[] theUnsupportedActions = { HttpMethod.PUT, HttpMethod.POST, HttpMethod.DELETE, HttpMethod.PATCH };
		
		// disable HTTP methods for Product: PUT, POST, DELETE and PATCH
		config.getExposureConfiguration().forDomainType(Product.class)
				.withItemExposure((metdata, httpMethods) -> httpMethods.disable(theUnsupportedActions))
				.withCollectionExposure((metdata, httpMethods) -> httpMethods.disable(theUnsupportedActions));

		// disable HTTP methods for ProductCategory: PUT, POST, DELETE and PATCH
		config.getExposureConfiguration().forDomainType(ProductCategory.class)
				.withItemExposure((metdata, httpMethods) -> httpMethods.disable(theUnsupportedActions))
				.withCollectionExposure((metdata, httpMethods) -> httpMethods.disable(theUnsupportedActions));

		// call an internal helper method to expose the Id`s
		exposeIds(config);

	}

	/**
	 * expose entity ids
	 * 
	 * @param config
	 */
	private void exposeIds(RepositoryRestConfiguration config) {

		// get a list from all entity class from the entity manager
		Set<EntityType<?>> entities = entityManager.getMetamodel().getEntities();

		// create an array list of the entity type
		List<Class> entityClasses = new ArrayList<>();

		// get the entity types for the entities
		for (EntityType entitype : entities) {
			entityClasses.add(entitype.getJavaType());
		}

		// expose the entity id for the entity/domain types
		Class[] domainTypes = entityClasses.toArray(new Class[0]);
		config.exposeIdsFor(domainTypes);

	}
}