package generator.base.entity;
import de.greenrobot.daogenerator.Entity;
import de.greenrobot.daogenerator.Schema;


/**
 * @author aivarsda
 *
 */
public abstract class AGenEntity implements IEntity 
{
	protected Schema _schema;
	
	@SuppressWarnings("unused")
	private AGenEntity() {}; // java.lang.NoClassDefFoundError: freemarker/template/ObjectWrapper
	
	public AGenEntity(Schema schema) 
	{
		_schema = schema;
	}
	
	/**
	 * Adding the Serializable implementation to the entity
	 * @return
	 */
	public Entity addSerializableEntity() 
	{
		Entity entity = addEntity();
		entity.implementsSerializable();
		
		return entity;
	}
	
	@Override
	public abstract Entity addEntity();

}
