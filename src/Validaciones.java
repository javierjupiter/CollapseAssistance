import java.util.regex.Pattern;

public class Validaciones {
    private String regexCURP = "^[A-Z][AEIOU][A-Z]{2}[0-9]{2}" +
        "(0[1-9]|1[0-2])(0[1-9]|1[0-9]|2[0-9]|3[0-1])" +
        "[HM]" +
        "(AS|BC|BS|CC|CS|CH|CL|CM|DF|DG|GT|GR|HG|JC|MC|MN|MS|NT|NL|OC|PL|QT|QR|SP|SL|SR|TC|TS|TL|VZ|YN|ZS|NE)" +
        "[B-DF-HJ-NP-TV-Z]{3}" +
        "[0-9A-Z]{1}[0-9]$";
    private Pattern patronCURP = Pattern.compile(regexCURP);

    private String anyiobiciesto = "((19[579][26])|(19[68][048])|(201[26])|(20[02][048]))";
    private String anyoNormal = "((19[579][01345789])|(19[68][1235679])|(201[01345789])|(20[02][1235679]))";
    private String mesLargo = "(0[13578]|1[02])-(0[1-9]|[12][0-9]|3[01])";
    private String mesCorto = "(0[469]|11)-(0[1-9]|[12][0-9]|30)";
    private String febreroLargo = "02-(0[1-9]|[12][0-9])";
    private String febreroCorto = "02-(0[1-9]|[12][0-8])";

    private String regexFecha = "^(" + anyiobiciesto + "-(" + mesLargo + "|" + mesCorto + "|" + febreroLargo + "))|(" + anyoNormal + "-(" + mesLargo + "|" + mesCorto + "|" + febreroCorto + "))$";
    private Pattern patronFecha = Pattern.compile(regexFecha);

    private String regexNombre = "^(([A-ZÁÉÍÓÚÑ][a-záéíóúñ]*+)[ ]*)+$"; //Acepta solo con la primera letra de cada palabra con mayusculas, las siguientes deben ser minusculas
    private Pattern patronNombre = Pattern.compile(regexNombre);

    private String regexCadenas = "^(([A-ZÁÉÍÓÚÑ][a-záéíóúñ]*)[ \\.,¿?¡!\\-_\\*\\+/]*)+$";
    private Pattern patronCadenas = Pattern.compile(regexCadenas);

    private String regexClave = "^[0-9]{6}$";
    private Pattern patronClave = Pattern.compile(regexClave);

    private String regexNumeroDireccion = "^([0-9 A-Za-z]|-)+$";
    private Pattern patronNumeroDireccion = Pattern.compile(regexNumeroDireccion);

    private String regexCP = "^[0-9]{5}$";
    private Pattern patronCP = Pattern.compile(regexCP);

    private String regexIDEstado = "^[0-9]{2}$";
    private Pattern patronIDEstado = Pattern.compile(regexIDEstado);

    private String regexIDMunicipio = "^[0-9]{4}$";
    private Pattern patronIDMunicipio = Pattern.compile(regexIDMunicipio);

    public boolean validarCURP(String curpDato){
        if (patronCURP.matcher(curpDato).matches()) {
            return true;
        } else {
            System.out.println("CURP invalido, ingrese nuevamente");
            return false;
        }
    }

    public boolean validarFecha(String fecha){
        if (patronFecha.matcher(fecha).matches()){
            return true;
        } else{
            System.out.println("Fecha invalida, ingrese nuevamente");
            return false;
        }
    }

    public boolean validarNombre(String cadena){
        if (patronNombre.matcher(cadena).matches()){
            return true;
        } else {
            System.out.println("Cadena invalida, ingrese nuevamente");
            return false;
        }
    }

    public boolean validarCadenas(String cadena){
        if (patronCadenas.matcher(cadena).matches()){
            return true;
        } else {
            return false;
        }
    }

    public boolean validarClave(String clave){
        if (patronClave.matcher(clave).matches()){
            return true;
        } else {
            System.out.println("Clave invalida, ingrese nuevamente");
            return false;
        }
    }

    public boolean validarNumeroDireccion(String numero){
        if (patronNumeroDireccion.matcher(numero).matches()){
            return true;
        } else{
            System.out.println("Numero invalido, ingrese nuevamente");
            return false;
        }
    }

    public boolean validarCP(String CP){
        if (patronCP.matcher(CP).matches()) {
            return true;
        } else {
            System.out.println("Código Postal invalida, ingrese nuevamente");
            return false;
        }
    }

    public boolean validarIDEstado(String IDEstado){
        if (patronIDEstado.matcher(IDEstado).matches()) {
            return true;
        } else {
            System.out.println("ID del estado invalido ingrese nuevamente");
            return false;
        }
    }

    public boolean validarIDMunicipio(String IDMunicipio){
        if (patronIDMunicipio.matcher(IDMunicipio).matches()) {
            return true;
        } else {
            System.out.println("ID del municipio invalido, ingrese nuevamente");
            return false;
        }
    }
}
