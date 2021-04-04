--------------------------------------------------------
--  File created - Saturday-March-27-2021   
--------------------------------------------------------
--------------------------------------------------------
--  DDL for Table PRODUCT
--------------------------------------------------------

  CREATE TABLE "HR"."PRODUCT" 
   (	"ID" NUMBER(19,0), 
	"ACTIVE" NUMBER(1,0), 
	"DATE_CREATED" DATE, 
	"DESCRIPTION" VARCHAR2(255 CHAR), 
	"IMAGE_URL" VARCHAR2(255 CHAR), 
	"LAST_UPDATED" DATE, 
	"NAME" VARCHAR2(255 CHAR), 
	"SKU" VARCHAR2(255 CHAR), 
	"UNIT_PRICE" NUMBER(19,2), 
	"UNITS_IN_STOCK" NUMBER(10,0), 
	"CATEGORY_ID" NUMBER(19,0)
   ) SEGMENT CREATION IMMEDIATE 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Index SYS_C007041
--------------------------------------------------------

  CREATE UNIQUE INDEX "HR"."SYS_C007041" ON "HR"."PRODUCT" ("ID") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS" ;
--------------------------------------------------------
--  DDL for Trigger PRODUCT_ID_INSERT
--------------------------------------------------------

  CREATE OR REPLACE TRIGGER "HR"."PRODUCT_ID_INSERT" before insert on product 
for each row
  WHEN (new.id is null) begin 
    :new.ID := product_seq.NEXTVAL;
    END;
/
ALTER TRIGGER "HR"."PRODUCT_ID_INSERT" ENABLE;
--------------------------------------------------------
--  Constraints for Table PRODUCT
--------------------------------------------------------

  ALTER TABLE "HR"."PRODUCT" ADD PRIMARY KEY ("ID")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "USERS"  ENABLE;
  ALTER TABLE "HR"."PRODUCT" MODIFY ("CATEGORY_ID" NOT NULL ENABLE);
  ALTER TABLE "HR"."PRODUCT" MODIFY ("ID" NOT NULL ENABLE);
--------------------------------------------------------
--  Ref Constraints for Table PRODUCT
--------------------------------------------------------

  ALTER TABLE "HR"."PRODUCT" ADD CONSTRAINT "FK5CYPB0K23BOVO3RN1A5JQS6J4" FOREIGN KEY ("CATEGORY_ID")
	  REFERENCES "HR"."PRODUCT_CATEGORY" ("ID") ENABLE;
