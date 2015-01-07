package generator.schemamodels.store.entities;

import generator.base.entity.AGenEntity;
import de.greenrobot.daogenerator.Entity;
import de.greenrobot.daogenerator.Schema;

/**
 * @author aivarsda
 *
 */
public class CustomerEntity extends AGenEntity
{

	public CustomerEntity(Schema schema) {
		super(schema);
	}

	@Override
	public Entity addEntity() 
	{
		Entity customer = _schema.addEntity("Customer");
		
		customer.addLongProperty("id").primaryKey().autoincrement();
		customer.addStringProperty("fname");
		customer.addStringProperty("lname");
		customer.addFloatProperty("totSpent");
		customer.addLongProperty("age");
			
		return customer;
	}

}
