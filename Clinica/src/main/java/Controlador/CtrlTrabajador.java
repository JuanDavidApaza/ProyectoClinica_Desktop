package Controlador;

import Modelo.DAO.CitaDAO;
import Modelo.DAO.HorarioDoctorDAO;
import Modelo.DAO.PacienteDAO;
import Vista.*;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CtrlTrabajador {

    private final VentanaTrabajador ventanaTrabajador;
    private final PacienteDAO pacienteDAO;

    public CtrlTrabajador(VentanaTrabajador ventanaTrabajador, PacienteDAO pacienteDAO) {
        this.ventanaTrabajador = ventanaTrabajador;
        this.pacienteDAO = pacienteDAO;

        this.ventanaTrabajador.setVisible(true);
        this.ventanaTrabajador.setLocationRelativeTo(null);

        // Asignar listeners a los botones
        this.ventanaTrabajador.btnPacienteReg.addActionListener(e -> mostrarVentanaPacienteRegistrado());
        this.ventanaTrabajador.btnPacienteInvit.addActionListener(e -> mostrarVentanaRegistrarPacienteInvitado());
        this.ventanaTrabajador.btnNuevoPaciente.addActionListener(e -> mostrarVentanaRegistrarNuevoPaciente());
        this.ventanaTrabajador.btnIraPago.addActionListener(e -> mostrarVentanaPago());
    }

    private void mostrarVentanaPago(){
        VentanaPago ventanaPago = new VentanaPago();
        ventanaTrabajador.dispose();
        new CtrlPago(ventanaPago);
        ventanaPago.setVisible(true);
    }
    private void mostrarVentanaPacienteRegistrado() {
        ventanaTrabajador.dispose(); // Cierra la ventana de trabajador
        VentanaPacienteRegistrado ventanaPacienteRegistrado = new VentanaPacienteRegistrado();
        VentanaPago ventanaPago = new VentanaPago();
        
        Connection connection = null;
        try {
            connection = Conexion.Conexion.getConnection();
            HorarioDoctorDAO horarioDoctorDAO = new HorarioDoctorDAO(connection);
            CitaDAO citaDAO = new CitaDAO(connection);
            new CtrlPacienteRegistrado(ventanaPacienteRegistrado, pacienteDAO, citaDAO, horarioDoctorDAO, ventanaTrabajador,ventanaPago);
            ventanaPacienteRegistrado.setVisible(true);
        } catch (SQLException ex) {
            Logger.getLogger(CtrlTrabajador.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void mostrarVentanaRegistrarPacienteInvitado() {
        RegistrarPacienteInvitadoJdialog registrarPacienteInvitadoJDialog = new RegistrarPacienteInvitadoJdialog(ventanaTrabajador, true);
        new CtrlRegistrarPacienteInvitado(registrarPacienteInvitadoJDialog, pacienteDAO);
        registrarPacienteInvitadoJDialog.setVisible(true);
    }

    private void mostrarVentanaRegistrarNuevoPaciente() {
        RegistrarNuevoPacienteJdialog registrarNuevoPacienteJDialog = new RegistrarNuevoPacienteJdialog(ventanaTrabajador, true);
        new CtrlRegistrarNuevoPaciente(registrarNuevoPacienteJDialog, pacienteDAO);
        registrarNuevoPacienteJDialog.setVisible(true);
    }
}


