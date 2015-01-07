package generator.base.schema;

import de.greenrobot.daogenerator.Schema;

/**
 * @author aivarsda
 *
 */
public abstract class AGenSchema extends Schema implements ISchema
{
	protected String _outRelativePath;

	public AGenSchema(int version, String defaultJavaPackage, String outRelativePath) {
		super(version, defaultJavaPackage);
		_outRelativePath = outRelativePath;
	}
	
	@Override
	public String getOutRelativePath() 
	{
		return _outRelativePath;
	}
	
	@Override
	public void initSchema(String defaultJavaPackage)
	{
	      this.setDefaultJavaPackageDao(defaultJavaPackage+".dao");
	      this.enableKeepSectionsByDefault();
	}
}
