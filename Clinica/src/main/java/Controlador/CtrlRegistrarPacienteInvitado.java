package Controlador;

import Modelo.DAO.PacienteDAO;
import Modelo.Paciente;
import Vista.RegistrarPacienteInvitadoJdialog;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import javax.swing.JOptionPane;

public class CtrlRegistrarPacienteInvitado {

    private final RegistrarPacienteInvitadoJdialog registrarPacienteInvitadoJdialog;
    private final PacienteDAO pacienteDAO;

    public CtrlRegistrarPacienteInvitado(RegistrarPacienteInvitadoJdialog registrarPacienteInvitadoJdialog, PacienteDAO pacienteDAO) {
        this.registrarPacienteInvitadoJdialog = registrarPacienteInvitadoJdialog;
        this.pacienteDAO = pacienteDAO;
        desactivarCajas();
        this.registrarPacienteInvitadoJdialog.btnRegistrar.addActionListener(e -> registrarPacienteInvitado());
        this.registrarPacienteInvitadoJdialog.btnCancelar.addActionListener(e -> cancelarRegistro());
        this.registrarPacienteInvitadoJdialog.btnConsultar.addActionListener(e -> buscarDatos());
    }
    
    private void desactivarCajas(){
        this.registrarPacienteInvitadoJdialog.cajaNombre.setEnabled(false);
        this.registrarPacienteInvitadoJdialog.cajaApellidos.setEnabled(false);
        this.registrarPacienteInvitadoJdialog.cajaSexo.setEnabled(false); 
    }
    
    private void limpiarCajas(){
        this.registrarPacienteInvitadoJdialog.cajaNombre.setText(" ");
        this.registrarPacienteInvitadoJdialog.cajaApellidos.setText(" ");
        this.registrarPacienteInvitadoJdialog.cajaSexo.setText(" ");
        this.registrarPacienteInvitadoJdialog.cajaDNI.setText(" ");

    }
    
    private void buscarDatos(){
        String token = "cGVydWRldnMucHJvZHVjdGlvbi5maXRjb2RlcnMuNjY3NjVjYTZkNDFiOTQxMTE0OGI1ODY2";
        String leerdni = registrarPacienteInvitadoJdialog.cajaDNI.getText();
        String enlace = "https://api.perudevs.com/api/v1/dni/complete?document=" + leerdni + "&key=" + token;

        try {
            URL url = new URL(enlace);
            URLConnection request = url.openConnection();
            request.connect();

            JsonParser jp = new JsonParser();
            JsonElement root = jp.parse(new InputStreamReader((InputStream) request.getContent()));

            if (root.isJsonObject()) {
                JsonObject rootobj = root.getAsJsonObject();

                String apellido_paterno = rootobj.has("resultado") ? rootobj.getAsJsonObject("resultado").has("apellido_paterno") ? rootobj.getAsJsonObject("resultado").get("apellido_paterno").getAsString() : "" : "";
                String apellido_materno = rootobj.has("resultado") ? rootobj.getAsJsonObject("resultado").has("apellido_materno") ? rootobj.getAsJsonObject("resultado").get("apellido_materno").getAsString() : "" : "";
                String nombres = rootobj.has("resultado") ? rootobj.getAsJsonObject("resultado").has("nombres") ? rootobj.getAsJsonObject("resultado").get("nombres").getAsString() : "" : "";
                String genero = rootobj.has("resultado") ? rootobj.getAsJsonObject("resultado").has("genero") ? rootobj.getAsJsonObject("resultado").get("genero").getAsString() : "" : "";
                String fecha_nacimiento = rootobj.has("resultado") ? rootobj.getAsJsonObject("resultado").has("fecha_nacimiento") ? rootobj.getAsJsonObject("resultado").get("fecha_nacimiento").getAsString() : "" : "";
                String nombre_completo = rootobj.has("resultado") ? rootobj.getAsJsonObject("resultado").has("nombre_completo") ? rootobj.getAsJsonObject("resultado").get("nombre_completo").getAsString() : "" : "";
                String codigo_verificacion = rootobj.has("resultado") ? rootobj.getAsJsonObject("resultado").has("codigo_verificacion") ? rootobj.getAsJsonObject("resultado").get("codigo_verificacion").getAsString() : "" : "";
                
                //Rellenar en cajas
                registrarPacienteInvitadoJdialog.cajaNombre.setText(nombres);
                registrarPacienteInvitadoJdialog.cajaApellidos.setText(apellido_paterno + " " + apellido_materno);
                registrarPacienteInvitadoJdialog.cajaSexo.setText(genero);
   
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
            JOptionPane.showMessageDialog(null, "DNI NO REGISTRADO EN LA RENIEC");
            desactivarCajas();
            limpiarCajas();
        }
    }

    private void registrarPacienteInvitado() {
        String dni = registrarPacienteInvitadoJdialog.cajaDNI.getText().trim(); // Trim para eliminar espacios en blanco
        String nombre = registrarPacienteInvitadoJdialog.cajaNombre.getText();
        String apellido = registrarPacienteInvitadoJdialog.cajaApellidos.getText();
        String direccion = null ;
        String telefono = null;
        String email = null;
        String sexo = registrarPacienteInvitadoJdialog.cajaSexo.getText();
        int edad=0;

        // Validaciones
        // Validar si el DNI ya existe
        if (pacienteDAO.existeDNI(dni)) {
            JOptionPane.showMessageDialog(null, "El DNI ingresado ya existe");
            return;
        }

        // Crear el objeto
        Paciente paciente = new Paciente(dni, nombre, apellido, direccion, telefono, email, sexo, edad, 0, "Invitado");

        // Insertar el paciente en la base de datos
        if (pacienteDAO.insertarPaciente(paciente)) {
            JOptionPane.showMessageDialog(null, "Paciente invitado, ir a registrar cita");
            registrarPacienteInvitadoJdialog.dispose();
        } else {
            JOptionPane.showMessageDialog(null, "Error ");
        }
    }

    private void cancelarRegistro() {
        registrarPacienteInvitadoJdialog.dispose();
    }
}
