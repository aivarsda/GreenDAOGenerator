package generator.schemamodels.store.entities;

import generator.base.entity.AGenEntity;
import de.greenrobot.daogenerator.Entity;
import de.greenrobot.daogenerator.Property;
import de.greenrobot.daogenerator.Schema;

/**
 * @author aivarsda
 *
 */
public class ProductOrderEntity extends AGenEntity {

	private Entity _purchase;
	private Entity _product;
	
	public ProductOrderEntity(Schema schema, Entity purchase, Entity product) {
		super(schema);
		
		_purchase = purchase;
		_product = product;
	}

	@Override
	public Entity addEntity()
	{
		Entity productOrder = _schema.addEntity("ProductOrder");
		
		productOrder.addLongProperty("id").primaryKey().autoincrement();
		productOrder.addDateProperty("addTime");
		productOrder.addLongProperty("quantity");
		productOrder.addFloatProperty("totPrice");
		
		Property product = productOrder.addLongProperty("product").getProperty();
		Property purchase = productOrder.addLongProperty("purchase").getProperty();
		_product.addToMany(productOrder, product);
		_purchase.addToMany(productOrder, purchase);
		
		return productOrder;
	}
}