package generator.schemamodels.store.entities;

import generator.base.entity.AGenEntity;
import de.greenrobot.daogenerator.Entity;
import de.greenrobot.daogenerator.Property;
import de.greenrobot.daogenerator.Schema;

/**
 * @author aivarsda
 *
 */
public class PurchaseEntity extends AGenEntity {

	private Entity _customer;
	
	public PurchaseEntity(Schema schema, Entity customer) {
		super(schema);
		
		_customer = customer;
	}

	@Override
	public Entity addEntity() 
	{
		Entity purchase = _schema.addEntity("Purchase");
		
		purchase.addLongProperty("id").primaryKey().autoincrement();
		purchase.addDateProperty("startTime");
		purchase.addDateProperty("endTime");
		purchase.addStringProperty("name");
		
		Property customer = purchase.addLongProperty("customer").getProperty();
		_customer.addToMany(purchase, customer);
		
		return purchase;
	}

}