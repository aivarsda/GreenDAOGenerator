import generator.Generator;

import java.io.IOException;
import de.greenrobot.daogenerator.DaoGenerator;

/**
 * @author aivarsda
 *
 */
public class Main extends DaoGenerator 
{
	public Main() throws IOException {	}

	public static void main(String[] args) 
	{
		new Generator().generate();
	}
}
