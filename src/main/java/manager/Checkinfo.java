package manager;

public class Checkinfo {

	private static final String Correspondencia = "TRWAGMYFPDXBNJZSQVHLCKE";

	// Funciones

	public static boolean tryParseInt(String value) {
		try {
			Integer.parseInt(value);
			return true;
		} catch (NumberFormatException nfe) {
			return false;
		}
	}

	// NIE DNI
	public static char get_NIFletter(String numero) {
		// chequeamos que no sea nulo tenga la longitud correcta y lo pasamos a
		// INT
		int n = 0;

		try {
			n = Integer.parseInt(numero);
			if ((numero == null) || (numero.length() != 8)) {
				// añadir excepcionen idiomas *******
				throw new Exception("El DNI debe contener 8 dígitos.");

			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return Correspondencia.charAt((n % 23));

	}

	// funcion que genera la letra del NIE
	public static char get_NIEletter(String numero) {
		int n = 0;
		try {

			// chequeamos si la letra del dni es correcto.
			if ((numero == null) || (numero.length() != 8) || ((Character.toUpperCase(numero.charAt(0)) != 'X') && (Character.toUpperCase(numero.charAt(0)) != 'Y') && (Character.toUpperCase(numero.charAt(0)) != 'Z')) || (!tryParseInt(numero.substring(1, 7)))) {
				n = Integer.parseInt(numero.substring(1, 7));
				// añadimso excepcion en idiomas ******
				throw new Exception("El NIE debe comenzar con la letra X, Y o Z seguida de 7 dígitos.");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		// sumamso segunsea el caso de extrangeria
		switch (Character.toUpperCase(numero.charAt(0))) {
		case 'X':
			return Correspondencia.charAt(n % 23);
		case 'Y':
			return Correspondencia.charAt((10000000 + n) % 23);
		case 'Z':
			return Correspondencia.charAt((20000000 + n) % 23);
		default:
			return '\0';
		}
	}

	// Funcion que checkea si la nacionalidad corresponde con el NIF-NIE
	public static boolean checknationality(int nacionalidad, String numero) {
		boolean correcto = false;

		// Chequeamos la nacionalidad
		if (nacionalidad == 0) {
			if ((numero.charAt(0) != 'X') && (numero.charAt(0) != 'Y') && (numero.charAt(0) != 'Z'))
				correcto = true;
		} else {
			if ((numero.charAt(0) == 'X') || (numero.charAt(0) == 'Y') || (numero.charAt(0) == 'Z'))
				correcto = true;
		}
		return (correcto);
	}

	// Funcion que chekea que la letra sea la correcta.
	public static boolean checkletter(int nacionalidad, String letra, String numero) {
		char let;
		boolean correcto = false;

		// chequeamos la letra
		if (nacionalidad == 0) {
			let = get_NIFletter(numero);
		} else {
			let = get_NIEletter(numero);
		}

		if (Character.toString(let) == letra)
			correcto = true;

		return (correcto);

	}
	
	public static boolean check_fijophone(String telf)
    {
        boolean encontrado = false;

        if ((telf.length() == 9 && telf.charAt(0) == '9') || (telf.length() == 9 && telf.charAt(0) == '8') || telf.length() == 9 && telf.charAt(0) == '7')
            encontrado = true;
        if (telf.charAt(0) == '+')
            encontrado = true;

        //check si el numero es correcto

        return (encontrado);
    }

    public static boolean check_movil(String movil)
    {
        boolean encontrado = false;

        if ((movil.length()  == 9 && movil.charAt(0) == '6') || (movil.length()  == 9 && movil.charAt(0) == '7'))
            encontrado = true;
        if (movil.charAt(0) == '+')
            encontrado = true;

        //check si el numero es correcto

        return (encontrado);
    }

    //chekear email contiene @
    public static boolean check_email(String mail)
    {
        boolean encontrado = false;
        String[] partes = mail.split("@");

        if (partes.length == 2)
            encontrado = true;

        return (encontrado);
    }

}
