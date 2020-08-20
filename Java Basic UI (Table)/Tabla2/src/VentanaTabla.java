import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.io.*;

public class VentanaTabla {

    public static void main(String[] args) {
        JFrame ventana = new JFrame("Extra Clase I");
        JTable tabla = new JTable();
        DefaultTableModel modelo = new DefaultTableModel();

        String archivo = OpenFile();
        String separador = ",";
        BufferedReader br = null;
        verificarTipo(archivo);

        try {
            br = new BufferedReader(new FileReader(archivo));
            String line = br.readLine();
            int cont = 0;
            int i = 0;
            if (br.readLine() == null) {
                throw new IOException();
            }
            else {
                while (null != line) {
                    String[] fields = line.split(separador);
                    line = br.readLine();
                    if (cont == 0) {
                        Object[] cabecera = new Object[fields.length];
                        while (i != fields.length) {
                            cabecera[i] = fields[i];
                            i++;
                        }
                        cont += 1;
                        modelo.setColumnIdentifiers(cabecera);
                        i = 0;
                    } else {
                        Object[] datos = new Object[fields.length];
                        while (i != fields.length) {
                            datos[i] = fields[i];
                            i++;
                        }
                        modelo.addRow(datos);
                        datos = null;
                        i = 0;
                    }
                }
            }
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "El archivo está vacío o no existe");
            System.exit(1);

        } finally {
            if (null != br) {
                try {
                    br.close();
                } catch (IOException ex) {
                    JOptionPane.showMessageDialog(null, "Error al salir del archivo");
                    System.exit(1);
                }
            }
        }
        tabla.setModel(modelo);
        tabla.setBackground(Color.WHITE);
        ventana.setSize(330, 250);
        tabla.setRowHeight(30);
        ventana.add(tabla);
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        tabla.setVisible(true);
        ventana.setVisible(true);
    }

    public static String OpenFile() {
        try {
            JButton open = new JButton();
            JFileChooser nf = new JFileChooser();
            File file = new File("C:/Documentos");
            nf.setCurrentDirectory(file);
            if (nf.showOpenDialog(open) == JFileChooser.APPROVE_OPTION) {
                return nf.getSelectedFile().getAbsolutePath();
            }
                //System.out.println(nf.getSelectedFile().getAbsolutePath());
            else if (nf.showOpenDialog(open) == JFileChooser.CANCEL_OPTION) {
                throw new NullPointerException();
            }

        } catch (NullPointerException e) {
            JOptionPane.showMessageDialog(null, "El archivo no fue seleccionado correctamente");
            System.exit(1);
            return "No existe";
        }
        return null;
    }

    public static void verificarTipo (String archivo) {
        try{
            if (archivo.contains(".csv") == false) {
                System.out.println(archivo.contains(".csv"));
                throw new Exception();
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error en el formato del archivo, debe ser .csv");
            System.exit(1);
        }
    }
}