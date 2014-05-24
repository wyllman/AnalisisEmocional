/**
 * 
 */
package es.ull.etsii.ull.interfaz.graficos.componentes;

import java.awt.Color;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JSeparator;

import es.ull.etsii.iaa.proyecto.interfaz.VentanaPrincipal;


/**
 * @author Juan Hen‡ndez Hern‡ndez
 * @author Guillermo Rodr’guez Pardo
 *
 */
public class BarraMenu extends JMenuBar {
   //______________________________________
   // Atributos constantes predeterminados:
   static final int ALTO = 30;	
   static final Color COL_FONDO = Color.gray;
   static final String ID = "menu_p";
   //-FIN---------------
   
   /**
    * 
    */
   public BarraMenu(VentanaPrincipal laVentana) {
      inicializar (laVentana, 0, 0, laVentana.getWidth(), ALTO);
   }

   public VentanaPrincipal getLaVentTmp_() {
      return laVentTmp_;
   }
   public void setLaVentTmp_(VentanaPrincipal laVentTmp_) {
      this.laVentTmp_ = laVentTmp_;
   }
   public JMenu getmArchivo_() {
      return mArchivo_;
   }
   public void setmArchivo_(JMenu mArchivo_) {
      this.mArchivo_ = mArchivo_;
   }

   //____________________
   // Atributos privados:
   private VentanaPrincipal laVentTmp_;
   
   private JMenu mArchivo_;
   //-FIN---------------
   
   


//__________________
   // MŽtodos privados:
   private void inicializar (VentanaPrincipal laVentana, int pos_x, int pos_y, 
                             int ancho, int alto) {
      setLaVentTmp_(laVentana);
      setName (ID);
      setBackground (COL_FONDO);
      setBounds (pos_x, pos_y, ancho, alto);

      // Inicializar el menœ "Archivo."
      setmArchivo_(new JMenu ("Archivo"));
      getmArchivo_().setBackground(COL_FONDO);
      //getmArchivo_().addMenuListener(getLosEventos_().getAccArchivo_());
      
      this.add(getmArchivo_());
      
	}
	//-FIN-------------------------
}
