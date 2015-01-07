package generator.schemamodels.tree.entities;

import generator.base.entity.AGenEntity;
import de.greenrobot.daogenerator.Entity;
import de.greenrobot.daogenerator.Property;
import de.greenrobot.daogenerator.Schema;

/**
 * @author aivarsda
 *
 */
public class TreeNodeEntity extends AGenEntity
{
	public TreeNodeEntity(Schema schema){
		super(schema);
	}

	@Override
	public Entity addEntity() 
	{
		Entity treeNodeEntity = _schema.addEntity("TreeNode");
		treeNodeEntity.addIdProperty();
		Property parentIdProperty = treeNodeEntity.addLongProperty("parentId").getProperty();
		treeNodeEntity.addToOne(treeNodeEntity, parentIdProperty).setName("parent");
		treeNodeEntity.addToMany(treeNodeEntity, parentIdProperty).setName("children");
		
		return treeNodeEntity;
	}
}
