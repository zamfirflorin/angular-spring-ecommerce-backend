create or replace package computations
is
    function f1(name1 in varchar2, temp_emp_id out number, temp_emp_salary out number)
    return number;
end;

create or replace package body computations
is
    function f1(name1 in varchar2, temp_emp_id out number, temp_emp_salary out number)
        return number
    is
        begin 
        select employee_id, salary into temp_emp_id, temp_emp_salary
        from employees where first_name = name1;
        return 1;
    end;
end;

