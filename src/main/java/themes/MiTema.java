package themes;

import com.formdev.flatlaf.FlatLightLaf;

public class MiTema
	extends FlatLightLaf
{
	public static final String NAME = "MiTema";

	public static boolean setup() {
		return setup( new MiTema() );
	}

	public static void installLafInfo() {
		installLafInfo( NAME, MiTema.class );
	}

	@Override
	public String getName() {
		return NAME;
	}
}
