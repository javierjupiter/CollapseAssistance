import java.util.regex.Pattern;

public class Validaciones {
    private final String regexCURP = "^[A-Z][AEIOU][A-Z]{2}[0-9]{2}" +
        "(0[1-9]|1[0-2])(0[1-9]|1[0-9]|2[0-9]|3[0-1])" +
        "[HM]" +
        "(AS|BC|BS|CC|CS|CH|CL|CM|DF|DG|GT|GR|HG|JC|MC|MN|MS|NT|NL|OC|PL|QT|QR|SP|SL|SR|TC|TS|TL|VZ|YN|ZS|NE)" +
        "[B-DF-HJ-NP-TV-Z]{3}" +
        "[0-9A-Z][0-9]$";
    private final Pattern patronCURP = Pattern.compile(regexCURP);

    private final String anyiobiciesto = "((19[579][26])|(19[68][048])|(201[26])|(20[02][048]))";
    private final String anyoNormal = "((19[579][01345789])|(19[68][1235679])|(201[01345789])|(20[02][1235679]))";
    private final String mesLargo = "(0[13578]|1[02])-(0[1-9]|[12][0-9]|3[01])";
    private final String mesCorto = "(0[469]|11)-(0[1-9]|[12][0-9]|30)";
    private final String febreroLargo = "02-(0[1-9]|[12][0-9])";
    private final String febreroCorto = "02-(0[1-9]|[12][0-8])";

    private final String regexFecha = "^(" + anyiobiciesto + "-(" + mesLargo + "|" + mesCorto + "|" + febreroLargo + "))|(" + anyoNormal + "-(" + mesLargo + "|" + mesCorto + "|" + febreroCorto + "))$";
    private final Pattern patronFecha = Pattern.compile(regexFecha);

    //Acepta solo con la primera letra de cada palabra con mayusculas, las siguientes deben ser minusculas
    private final String regexNombre = "^(([A-ZÀÁÂÄÃÅĄĆČĖĘÈÉÊËÌÍÎÏĮŁŃÒÓÔÖŌÕØÙÚÛÜŲŪŸÝŻŹÑßÇŒÆČŠŽ\\\\-][a-zàáâäãåąčćęèéêëėįìíîïłńòóōôöõøùúûüųūÿýżźñçčšžð\\\\-]*)|de la|de|del|y)(( [A-ZÀÁÂÄÃÅĄĆČĖĘÈÉÊËÌÍÎÏĮŁŃÒÓÔÖŌÕØÙÚÛÜŲŪŸÝŻŹÑßÇŒÆČŠŽ\\\\-][a-zàáâäãåąčćęèéêëėįìíîïłńòóōôöõøùúûüųūÿýżźñçčšžð\\\\-]*)| de la| de| del| y|-[A-ZÀÁÂÄÃÅĄĆČĖĘÈÉÊËÌÍÎÏĮŁŃÒÓÔŌÖÕØÙÚÛÜŲŪŸÝŻŹÑßÇŒÆČŠŽ\\\\-][a-zàáâäãåąčćęèéêëėįìíîïłńòóōôöõøùúûüųūÿýżźñçčšžð\\\\-]*|´|'[A-ZÀÁÂÄÃÅĄĆČĖĘÈÉÊËÌÍÎÏĮŁŃÒÓÔŌÖÕØÙÚÛÜŲŪŸÝŻŹÑßÇŒÆČŠŽ\\\\-]?[a-zàáâäãåąčćęèéêëėįìíîïłńòóôōöõøùúûüųūÿýżźñçčšžð\\\\-]*)*$";
    private final Pattern patronNombre = Pattern.compile(regexNombre);

    private final String regexCadenas = "^[A-ZÁÉÍÓÚÑ][a-zA-z0-9\\(\\) ]*$";
    private final Pattern patronCadenas = Pattern.compile(regexCadenas);

    private final String regexClave = "^[0-9]{6}$";
    private final Pattern patronClave = Pattern.compile(regexClave);

    private final String regexNumeroDireccion = "^([0-9 A-Za-z]|-)+$";
    private final Pattern patronNumeroDireccion = Pattern.compile(regexNumeroDireccion);

    private final String regexCP = "^[0-9]{5}$";
    private final Pattern patronCP = Pattern.compile(regexCP);

    private final String regexIDEstado = "^([0-2][1-9]|3[0-2])$";
    private final Pattern patronIDEstado = Pattern.compile(regexIDEstado);

    private final String regexIDMunicipio = "^((000[1-9])|(00[0-9]{2})|([01][0-9]{3})|(2[0-4][0-5][0-8]))$";
    private final Pattern patronIDMunicipio = Pattern.compile(regexIDMunicipio);

    public boolean validarCURP(String curpDato){
        return patronCURP.matcher(curpDato).matches();
    }

    public boolean validarFecha(String fecha){
        return patronFecha.matcher(fecha).matches();
    }

    public boolean validarNombre(String cadena){
        return patronNombre.matcher(cadena).matches();
    }

    public boolean validarCadena(String cadena){
        return patronCadenas.matcher(cadena).matches();
    }

    public boolean validarClave(String clave){
        return patronClave.matcher(clave).matches();
    }

    public boolean validarNumeroDireccion(String numero){
        return patronNumeroDireccion.matcher(numero).matches();
    }

    public boolean validarCP(String CP){
        return patronCP.matcher(CP).matches();
    }

    public boolean validarIDEstado(String IDEstado){
        return patronIDEstado.matcher(IDEstado).matches();
    }

    public boolean validarIDMunicipio(String IDMunicipio){
        return patronIDMunicipio.matcher(IDMunicipio).matches();
    }
}
