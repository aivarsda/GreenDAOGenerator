Green DAO Generator Example
=====================
This is a simple yet flexible framework for the Green DAO Generator:
* All entities have Serializable implementation.
* Ability to generate several schemas to the project. 
* Ability to generate for several projects. (Handling different projects from one place)


How To Use
--------------

- <b>1. Generator class :</b>
<br>In the Generator class, add the default output project path.
```java
private final static String DEFAULT_PROJ_OUTPUT_PATH = "../../_fwGreenDAO/src";
```
- <b>2. Adding the schemas:</b>
```java
/**
 * Here is the ERD for the Store schema:
 *	 ----------        ----------
 *	| Customer | ---< | Purchase |
 *	 ----------        ----------
 *	                       |
 *						   |
 *						  / \
 *				     --------------
 *				    | ProductOrder |
 *				     --------------
 *						  \ /
 *						   |
 *						   |
 *				       ---------
 *				      | Product |
 *				       ---------	
 */
```

Providing the "output_package" in the destination project.
<br>By default DAO files will be placed in "output_package.dao" package.
<br>If needed, you can change it by overriding the initSchema() method in the concrete schema class.
```java
private List <Schema> getSchemas()
	{
		List <Schema> schemaList = new ArrayList<Schema>();
		schemaList.add(new StoreSchema(1, "com.aivarsda.greendao_fw.orm.store",DEFAULT_PROJ_OUTPUT_PATH));
		schemaList.add(new TreeSchema(1, "com.aivarsda.greendao_fw.orm.tree",DEFAULT_PROJ_OUTPUT_PATH));
		
		// You may generate for several projects.
		// Pass another project output path via constructor.
		schemaList.add(new StoreSchema(1,"com.aivarsda.anotherproj.orm.store","../../_anotherproj/src"));
		
		return schemaList;
	}
```
 
- <b>3. <b>Generating the schemas:</b>
 
```java
public void generate()
{
	List <Schema> schemaList = getSchemas();
try 
{
	for (int i=0; i<schemaList.size(); i++)
	{
		Schema schema = schemaList.get(i);
		new DaoGenerator().generateAll(schema, ((AGenSchema)schema).getOutRelativePath());
	}
} 
catch (Exception e) {
    e.printStackTrace();
}
}
```


## Contact Developer
Aivars Dalderis
* e-mail: <aivars.dalderis@gmail.com>
* LinkedIn: [Aivars Dalderis LinkedIn](http://il.linkedin.com/in/aivarsd)
