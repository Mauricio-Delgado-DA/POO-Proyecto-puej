package Vista;

import Controlador.MetodoPagoControlador;
import Clases.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class MetodoPagoVista extends javax.swing.JFrame {

    private JComboBox<String> cmbOpciones;
    private JTextField txtNombre, txtDato1, txtDato2, txtDato3;
    private JLabel lblNombre, lblDato1, lblDato2, lblDato3;
    private JButton btnProcesar, btnSalir;
    private JPanel panelCampos;

    MetodoPagoControlador controlador = new MetodoPagoControlador();

    public MetodoPagoVista() {
        initComponents();
        setLocationRelativeTo(null);
        setTitle("Método de Pago");
    }

    @SuppressWarnings("unchecked")
    private void initComponents() {
        JLabel lblTitulo = new JLabel("Métodos de Pago", SwingConstants.CENTER);
        lblTitulo.setFont(new Font("Segoe UI", Font.BOLD, 24));

        JLabel lblOpcion = new JLabel("Seleccione un método:");
        cmbOpciones = new JComboBox<>(new String[]{"Seleccione...", "Tarjeta", "Yape", "Pago Efectivo"});

        // Panel de campos dinámicos
        panelCampos = new JPanel();
        panelCampos.setLayout(new GridLayout(5, 2, 10, 10));
        panelCampos.setBackground(new Color(220, 225, 230));

        lblNombre = new JLabel("Nombre del titular:");
        txtNombre = new JTextField();

        lblDato1 = new JLabel("");
        txtDato1 = new JTextField();

        lblDato2 = new JLabel("");
        txtDato2 = new JTextField();

        lblDato3 = new JLabel("");
        txtDato3 = new JTextField();

        panelCampos.add(lblNombre);
        panelCampos.add(txtNombre);
        panelCampos.add(lblDato1);
        panelCampos.add(txtDato1);
        panelCampos.add(lblDato2);
        panelCampos.add(txtDato2);
        panelCampos.add(lblDato3);
        panelCampos.add(txtDato3);

        // Botones
        btnProcesar = new JButton("Procesar");
        btnSalir = new JButton("Salir");

        JPanel panelBotones = new JPanel();
        panelBotones.add(btnProcesar);
        panelBotones.add(btnSalir);

        // Panel principal
        JPanel panel = new JPanel();
        panel.setBackground(new Color(220, 225, 230));
        panel.setLayout(new BorderLayout(10, 10));

        JPanel topPanel = new JPanel(new GridLayout(3, 1, 5, 5));
        topPanel.setBackground(new Color(220, 225, 230));
        topPanel.add(lblTitulo);
        topPanel.add(lblOpcion);
        topPanel.add(cmbOpciones);

        panel.add(topPanel, BorderLayout.NORTH);
        panel.add(panelCampos, BorderLayout.CENTER);
        panel.add(panelBotones, BorderLayout.SOUTH);

        add(panel);
        pack();

        // Acciones
        cmbOpciones.addActionListener(this::actualizarCampos);
        btnSalir.addActionListener(e -> System.exit(0));
        btnProcesar.addActionListener(this::procesarPago);

        actualizarCampos(null); // Limpia campos al inicio
    }

    private void actualizarCampos(ActionEvent e) {
        int opcion = cmbOpciones.getSelectedIndex();

        // Ocultar todo al inicio
        lblNombre.setVisible(false);
        txtNombre.setVisible(false);
        lblDato1.setVisible(false);
        txtDato1.setVisible(false);
        lblDato2.setVisible(false);
        txtDato2.setVisible(false);
        lblDato3.setVisible(false);
        txtDato3.setVisible(false);

        if (opcion > 0) {
            lblNombre.setVisible(true);
            txtNombre.setVisible(true);
        }

        switch (opcion) {
            case 1 -> { // TARJETA
                lblDato1.setText("Número de tarjeta (16 dígitos):");
                lblDato2.setText("Fecha de vencimiento (MM/AA):");
                lblDato3.setText("CVV (3 dígitos):");

                lblDato1.setVisible(true);
                txtDato1.setVisible(true);
                lblDato2.setVisible(true);
                txtDato2.setVisible(true);
                lblDato3.setVisible(true);
                txtDato3.setVisible(true);
            }
            case 2 -> { // YAPE
                lblDato1.setText("Número de teléfono (9 dígitos):");
                lblDato1.setVisible(true);
                txtDato1.setVisible(true);
            }
            case 3 -> { // EFECTIVO
                lblDato1.setText("Código de transacción:");
                lblDato1.setVisible(true);
                txtDato1.setVisible(true);
            }
        }

        pack();
    }

    private void procesarPago(ActionEvent e) {
        int opcion = cmbOpciones.getSelectedIndex();

        if (opcion == 0) {
            JOptionPane.showMessageDialog(this, "Seleccione un método válido.");
            return;
        }

        String nombre = txtNombre.getText().trim();
        if (nombre.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Ingrese el nombre del titular.");
            return;
        }

        MetodoPago metodo = null;

        switch (opcion) {
            case 1 -> {
                PagoTarjeta tarjeta = new PagoTarjeta();
                tarjeta.setNombreTitular(nombre);
                tarjeta.setNumeroTarjeta(txtDato1.getText().trim());
                tarjeta.setFechaVencimiento(txtDato2.getText().trim());

                String cvv = txtDato3.getText().trim();
                if (!cvv.matches("\\d{3}")) {
                    JOptionPane.showMessageDialog(this, "El CVV debe tener 3 dígitos.");
                    return;
                }

                metodo = tarjeta;
            }
            case 2 -> {
                PagoYape yape = new PagoYape();
                yape.setNombreTitular(nombre);
                yape.setNumeroTelefono(txtDato1.getText().trim());
                metodo = yape;
            }
            case 3 -> {
                PagoEfectivo efectivo = new PagoEfectivo();
                efectivo.setNombreTitular(nombre);
                efectivo.setCodigoTransaccion(txtDato1.getText().trim());
                metodo = efectivo;
            }
        }

        if (metodo != null) {
            metodo.procesarPago();
            JOptionPane.showMessageDialog(this, "Pago procesado exitosamente con " +
                    cmbOpciones.getSelectedItem() + ".");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new MetodoPagoVista().setVisible(true));
    }
}
