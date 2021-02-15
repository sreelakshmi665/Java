package com.example.Java;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class JavaController {
List<EntityJava> list=new ArrayList<>();
Scanner scan=new Scanner(System.in);
@GetMapping("/EntityJava")
public List<EntityJava> getAllEmployees()
{
	return list;
	
}
@GetMapping("/EntityJava/{empId}")
public EntityJava getEmployeeWithId(@PathVariable Integer empId)
{
	for(EntityJava val:list)
	{
		if(val.getEmpId() == empId)
		{
			return val;
		}
	}
	return null;
}


@PostMapping("/EntityJava/newEntityJava")
public void addEntityJava(@RequestBody EntityJava emp) {
	list.add(emp);
	 System.out.println("Saving person information");
}
@DeleteMapping("/EntityJava/{Id}")
public void deleteEmployeeWithId(@PathVariable Integer Id)
{
	list.removeIf(val->val.getEmpId()==Id);
	//System.out.println("deleted");
}
@PutMapping("/EntityJava/{Id}/{salary}")
public List<EntityJava> updateEmployee(@PathVariable Integer Id,@PathVariable double salary)
{

	for(EntityJava val:list)
	{
		if(val.getEmpId()==Id)
		{
			//System.out.println("Enter salary to update");
			//double salary=scan.nextDouble();
			val.setSalary(salary);
		}
	}
	return list;
}
}
