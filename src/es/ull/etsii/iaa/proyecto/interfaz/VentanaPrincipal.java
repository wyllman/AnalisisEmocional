/**
 * 
 */
package es.ull.etsii.iaa.proyecto.interfaz;


import javax.swing.JFrame;

import es.ull.etsii.ull.interfaz.graficos.componentes.BarraMenu;

/**
 * @author Juan Hen‡ndez Hern‡ndez
 * @author Guillermo Rodr’guez Pardo
 *
 */
@SuppressWarnings("serial")
public class VentanaPrincipal extends JFrame {
   //_____________________________________
   // Atributos constantes predeterminados
   static final int ANCHO_VENT = 300;
   static final int ALTO_VENT = 200;
   static final String TITULO = "Proyecto IAA";
   static final int POS_X = 20;
   static final int POS_Y = 50;
   static final int ANCHO_BORDES = 10;
   //---------------------------

   /**
    * 
    */
   public VentanaPrincipal() {
      super (TITULO);
      inicializar (ANCHO_VENT, ALTO_VENT);
   }

   public BarraMenu getElMenu_() {
      return elMenu_;
   }
   public void setElMenu_(BarraMenu elMenu_) {
      this.elMenu_ = elMenu_;
   }
   
   
   //____________________
   // Atributos privados.
   private BarraMenu elMenu_;

   //___________________
   // MŽtodos privados:
   private void inicializar (final int ancho, final int alto) {
      setLayout(null);
      setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
      setSize(ancho, alto + 50);
      setLocation(POS_X, POS_Y);
      
      setElMenu_(new BarraMenu (this));
      add(getElMenu_());
      
      setResizable(false);
      //setSize(ancho, alto + 50);
      setVisible (true);
   }
	//--------------------

}
