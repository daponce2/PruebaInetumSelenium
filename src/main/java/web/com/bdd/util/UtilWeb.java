package web.com.bdd.util;

import cucumber.api.DataTable;
import cucumber.api.Scenario;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.Map;

public class UtilWeb {

    public static void main(String[] args) throws Exception {
        //generateToken();
        /*
        eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJfaWQiOiI1YjM2MmM5NWI1MjcxMzAwMTRjZjY0YzMiLCJhY2Nlc3MiOiJhdXRoIiwiaWF0IjoxNTMwMjc4MzEzfQ.EnVnSgQ8yc0Ek00XEoTNbhYKSHaDJiEvYVeCdmaR0Xw
         */


    }
    public static void createResponseFile(String serviceName,
                                          String formatFile,
                                          String numeroTarjeta,
                                          String Numerooperacion,
                                          String numeroDestino ,
                                          String cuentaabono,
                                          String monto,
                                          String monedaSigno) throws
            IOException {

        //Crea path del file
        File filePath = new File("response/" + serviceName + "/" + formatFile);
        filePath.mkdirs();
        //Nombre del file con formato fecha al final
        String finalFileName = serviceName + "." + formatFile;

        //Crea el file dentro del path creado
        File file = new File(filePath + "/" + finalFileName);

        System.out.println("finalFileName: " + finalFileName);

        if (file.createNewFile()) {
            System.out.println("File is created!");
        } else {
            System.out.println("File already exists.");
        }
        String response = "";
        response += "Tarjeta: " + numeroTarjeta +  System.lineSeparator();
        response += "Numero de Operación: " + Numerooperacion+ System.lineSeparator();
        response += "Cuenta Abono: " + cuentaabono  + System.lineSeparator();
        response += "Cuenta Destino: " + numeroDestino  + System.lineSeparator();
        response += "Monto: "+ monedaSigno+ " " + monto  + System.lineSeparator();
        response += "------------------------------";
        //Escribe la respueta dentro del file creado
        FileWriter fileWriter = new FileWriter(file,true);
        fileWriter.write(response + System.lineSeparator());
        fileWriter.close();
    }

    private static void embedImageCucumber(File[] folder, Scenario scenario) throws IOException {

        for (File file : folder) {
            if (file.getName().contains(".png")) {
                File imgPath = new File(file.getAbsolutePath());
                BufferedImage bufferedImage = ImageIO.read(imgPath);
                ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
                ImageIO.write(bufferedImage, "png", outputStream);

                byte[] screenShotByte = outputStream.toByteArray();
                scenario.embed(screenShotByte, "image/png");

            }
        }
    }

    public static String getValueFromDataTable(DataTable dataTable, String title) {
        List<Map<String, String>> list = dataTable.asMaps(String.class, String.class);
        return list.get(0).get(title);
    }


    public static String getNumDecimal(String cadena) {
        if (cadena == null) {
            return null;
        }
        String concat = "";
        for (int i = 0; i < cadena.length(); i++) {
            String sub = cadena.substring(i, i + 1);
            if (isNumeric(sub)) {
                concat += sub;
            }
            if (sub.equals(".")) {
                concat += ".";
            }
        }
        return concat;
    }

    public static boolean isNumeric(String str) {
        try {
            Integer.parseInt(str);
            return true;
        } catch (NumberFormatException nfe) {
            return false;
        }
    }

    public static void createResponseFileGenerateData(String serviceName,
                                          String formatFile,
                                          String numeroTarjeta,
                                          String Numerooperacion,
                                          String numeroDestino ,
                                          String cuentaabono,
                                          String monto,
                                          String monedaSigno) throws
            IOException {

        //Crea path del file
        File filePath = new File("response/" + serviceName + "/" + formatFile);
        filePath.mkdirs();
        //Nombre del file con formato fecha al final
        String finalFileName = serviceName + "." + formatFile;

        //Crea el file dentro del path creado
        File file = new File(filePath + "/" + finalFileName);

        System.out.println("finalFileName: " + finalFileName);

        if (file.createNewFile()) {
            System.out.println("File is created!");
        } else {
            System.out.println("File already exists.");
        }
        String response = "";
        response += "Tarjeta: " + numeroTarjeta +  System.lineSeparator();
        response += "Numero de Operación: " + Numerooperacion+ System.lineSeparator();
        response += "Cuenta Abono: " + cuentaabono  + System.lineSeparator();
        response += "Cuenta Destino: " + numeroDestino  + System.lineSeparator();
        response += "Monto: "+ monedaSigno+ " " + monto  + System.lineSeparator();
        response += "------------------------------";
        //Escribe la respueta dentro del file creado
        FileWriter fileWriter = new FileWriter(file,true);
        fileWriter.write(response + System.lineSeparator());
        fileWriter.close();
    }


}