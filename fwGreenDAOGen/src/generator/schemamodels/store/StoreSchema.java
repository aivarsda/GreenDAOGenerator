package generator.schemamodels.store;

import generator.base.schema.AGenSchema;
import generator.schemamodels.store.entities.CustomerEntity;
import generator.schemamodels.store.entities.ProductEntity;
import generator.schemamodels.store.entities.ProductOrderEntity;
import generator.schemamodels.store.entities.PurchaseEntity;
import de.greenrobot.daogenerator.Entity;

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
 * @author aivarsda
 *
 */
public class StoreSchema extends AGenSchema
{
	public StoreSchema(int version, String defaultJavaPackage, String outRelativePath ) 
	{
		super(version, defaultJavaPackage, outRelativePath);
		initSchema(defaultJavaPackage);
	}

	@Override
	public void initSchema(String defaultJavaPackage) 
	{
		super.initSchema(defaultJavaPackage);
        // Inserting all of the entities from ERD, related to this Schema.
		Entity customer = new CustomerEntity(this).addSerializableEntity();
        Entity purchase = new PurchaseEntity(this, customer).addSerializableEntity();
        Entity product = new ProductEntity(this).addSerializableEntity();
        new ProductOrderEntity(this, product, purchase).addSerializableEntity();
	}
}
