/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ControlWeb;

import ejb.CiudadEJB;
import ejb.GerenteEJB;
import ejb.ViajeEJB;
import entidad.Ciudad;
import entidad.Cliente;
import entidad.Gerente;
import entidad.Reserva;
import entidad.Viaje;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.component.html.HtmlDataTable;
import javax.faces.model.SelectItem;
import org.primefaces.event.DateSelectEvent; 

/**
 *
 * @author stiven
 */
@ManagedBean
@SessionScoped
public class TerminalMB {
    
    private Ciudad ciudad;//permite q los archivos html se enlacen a el.aqui estan los atributos ingresados en el formulario de xhtml
    private Cliente cliente;//permite q los archivos html se enlacen a el.aqui estan los atributos ingresados en el formulario de xhtml
    private Gerente gerente;//permite q los archivos html se enlacen a el.aqui estan los atributos ingresados en el formulario de xhtml
    private Reserva reserva;//permite q los archivos html se enlacen a el.aqui estan los atributos ingresados en el formulario de xhtml
    private Viaje viaje;
    private String mensaje, usuario="";
    private List<Gerente> gerentes;
    private List<Viaje> viajes;
    private List<Ciudad> ciudades;
    private List<Ciudad> selectOneMenu;
    private List<Gerente> selectOneMenu2;
    private HtmlDataTable gerenteSelect;
    private HtmlDataTable ciudadSelect;
    private HtmlDataTable viajeSelect;
    private ArrayList<SelectItem> destinoCiudad;
    private Date date2;
    public Date date1;
    private Short destinoprueba,empresaprueba;
    private Short idusuario;
//---------------------------------------------------------
    
     @EJB
    private GerenteEJB gerEJB ;
    @EJB
    private ViajeEJB viajEJB ;
    @EJB
    private CiudadEJB ciuEJB ;

    public Short getIdusuario() {
        return idusuario;
    }

    public void setIdusuario(Short idusuario) {
        this.idusuario = idusuario;
    }
    
    //----------------------
    
    private String fechaFormateada;

    public Short getEmpresaprueba() {
        return empresaprueba;
    }

    public void setEmpresaprueba(Short empresaprueba) {
        this.empresaprueba = empresaprueba;
    }

    public List<Gerente> getSelectOneMenu2() {
        return selectOneMenu2;
    }

    public void setSelectOneMenu2(List<Gerente> selectOneMenu2) {
        this.selectOneMenu2 = selectOneMenu2;
    }
    
    
    public List<Ciudad> getSelectOneMenu() {
        return selectOneMenu;
    }

    public void setSelectOneMenu(List<Ciudad> selectOneMenu) {
        this.selectOneMenu = selectOneMenu;
    }
    @PostConstruct
    public void init() {
    selectOneMenu = ciuEJB.obtenerCiudades();
    
    selectOneMenu2 = gerEJB.obtenerGerentes();
    // If this is a static list, you'd rather put this
    // in a separate application scoped bean instead.
}
    public Short getDestinoprueba() {
        return destinoprueba;
    }

    public void setDestinoprueba(Short destinoprueba) {
        this.destinoprueba = destinoprueba;
    }
    
    public Ciudad getCiudad() {
        return ciudad;
    }

    public void setCiudad(Ciudad ciudad) {
        this.ciudad = ciudad;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Gerente getGerente() {
        return gerente;
    }

    public void setGerente(Gerente gerente) {
        this.gerente = gerente;
    }

    public Reserva getReserva() {
        return reserva;
    }

    public void setReserva(Reserva reserva) {
        this.reserva = reserva;
    }

    public Viaje getViaje() {
        return viaje;
    }

    public void setViaje(Viaje viaje) {
        this.viaje = viaje;
    }

    public List<Gerente> getGerentes() {
        return gerentes;
    }

    public List<Viaje> getViajes() {
        return viajes;
    }

    public void setViajes(List<Viaje> viajes) {
        this.viajes = viajes;
    }
    

    public void setGerentes(List<Gerente> gerentes) {
        this.gerentes = gerentes;
    }

    public HtmlDataTable getGerenteSelect() {
        return gerenteSelect;
    }

    public void setGerenteSelect(HtmlDataTable gerenteSelect) {
        this.gerenteSelect = gerenteSelect;
    }

    public HtmlDataTable getViajeSelect() {
        return viajeSelect;
    }

    public void setViajeSelect(HtmlDataTable viajeSelect) {
        this.viajeSelect = viajeSelect;
    }

    public HtmlDataTable getCiudadSelect() {
        return ciudadSelect;
    }

    public void setCiudadSelect(HtmlDataTable ciudadSelect) {
        this.ciudadSelect = ciudadSelect;
    }
    

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public List<Ciudad> getCiudades() {
        return ciudades;
    }

    public void setCiudades(List<Ciudad> ciudades) {
        this.ciudades = ciudades;
    }

    public Date getDate1() {
        return date1;
    }

    public void setDate1(Date date1) {
        this.date1 = date1;
    }

    public Date getDate2() {
        return date2;
    }

    public void setDate2(Date date2) {
        this.date2 = date2;
    }
 
    
 //---------------------------------------------------------  

    

    
    public String mostrarFormLogin(){
    //mensaje="";//clareamos la vista
    gerente=new Gerente(); //creamos el objeto Gerente
    return "formLogin.xhtml";
    }
    
    public String verificarLogin(){
    Gerente elgerente=new Gerente();
    gerentes=new ArrayList<Gerente>(); //vamos a crear la lista
    gerentes=gerEJB.obtenerGerentes(); //capturo todos los gerentes de la lista
    String retornar="";
    for(int i=0;i<gerentes.size();i++){
         
     elgerente=gerentes.get(i);

     if(gerente.getLogin().equals("admin") && gerente.getPassword().equals("123"))
     {
       //msjLogin="";  
       usuario="Administrador";
       retornar= "menuAdmin.xhtml";
     }
     
     else if(elgerente.getLogin().equals(gerente.getLogin())&& elgerente.getPassword().equals(gerente.getPassword())){
         //viaje.setIdgerente(elgerente.getIdgerente());
         idusuario=elgerente.getIdgerente();//capturamo el id del gerente
          //usuario=elgerente.getNombres();
         return "menuGerente";
          //retornar="menuGerente.xhtml";
          //msjLogin="";
          }
    else {
            retornar="formLogin.xhtml";
        }
     //msjLogin="Login o Contraseña incorrectos!";
     
    }
        
        return retornar;
    
    }
    
    
    public String mostrarlistarGerentes()
    {
        gerentes= new ArrayList<Gerente>();
        gerentes= gerEJB.obtenerGerentes();
        return "listarGerentes.xhtml";
    }
    
    public String mostrarcrearGerente(){
    gerente=new Gerente();    
    return "crearGerente.xhtml";
    }
    
    public String crearGerente(){
       
    if (gerEJB.creargerente(gerente)== true) {
        mensaje= "Gerente creado exitosamente!";
    
    }else {
        mensaje="Gerente No Creado!";
    }  
    
    return mostrarlistarGerentes();
    //return "listarCiudades.xhtml";
    
    }
    
    public String mostrareditarGerente(){
        mensaje="";
        gerente= new Gerente();
        gerente=(Gerente)gerenteSelect.getRowData();
        return "editarGerente.xhtml";
    }
    
    public String editarGerente(){
    
    if (gerEJB.editarGerente(gerente)== true) {
        mensaje= "gerente editado exitosamente!";
    }
    else {
        mensaje="el gerente NO pudo ser editado!";
    }   
    return "listarGerentes.xhtml";
    
    }
    
    public String mostrareliminarGerente(){
        mensaje="";
        gerente= new Gerente();
        gerente=(Gerente)gerenteSelect.getRowData();
        return "eliminarGerente.xhtml";
    } 
    
        public String eliminarGerente(){
    
    if (gerEJB.eliminarGerente(gerente)== true) {
        mensaje= "gerente eliminado exitosamente!";
    }
    else {
        mensaje="El gerente NO pudo ser eliminado del sistema!";
    }   
      return mostrarlistarGerentes();
     }
        
    public String mostrarlistarViajes()
    {
        viajes= new ArrayList<Viaje>();
        viajes= viajEJB.obtenerViajes();
        return "listarViajes.xhtml";
    }
    public String mostrarcrearViaje(){
    viaje=new Viaje();    
    return "crearViaje.xhtml";
    }
    
    public String mostrarlistarDestinos()
    {
        ciudades= new ArrayList<Ciudad>();
        ciudades= ciuEJB.obtenerCiudades();
        return "listarCiudades.xhtml";
    }
    
    public String mostrarlistarEmpresas()
    {
        viajes= new ArrayList<Viaje>();
        System.out.println("empresa prueba "+empresaprueba);
        viajes= viajEJB.recuperarDestino(empresaprueba);
        
        return "listarEmpresas.xhtml";
    }

    public String mostrarcrearCiudad(){
    ciudad=new Ciudad();    
    return "crearCiudad.xhtml";
    }
    
    public String crearCiudad(){
       
    if (ciuEJB.crearciudad(ciudad)== true) {
        mensaje= "Ciudad creada exitosamente!";
    
    }else {
        mensaje="Ciudad No Creada!";
    }  
    
    return mostrarlistarDestinos();
    }
    
   public String crearViaje() throws ParseException{
        
//----------------------------      
       SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
       String fechaFormateada = formato.format(date1);
       System.out.println("LA FECHA FORMATEADA ES: "+fechaFormateada);
       
       SimpleDateFormat formato2 = new SimpleDateFormat("dd/MM/yyyy");
       Date fechaa=null;
       
       try{
       fechaa = formato2.parse(fechaFormateada);
       System.out.println("LA FECHA DEFINITIVA EN LA B.D ES: "+fechaa);
       }
       catch (ParseException ex){
       ex.printStackTrace();
       }
//----------------------------       
       SimpleDateFormat formatohora = new SimpleDateFormat("HH:mm");
       String horaFormateada = formatohora.format(date2);
       System.out.println("LA HORA FORMATEADA ES: "+horaFormateada);
       
       SimpleDateFormat formatohora2 = new SimpleDateFormat("HH:mm");
       Date hora=null;
       
       try{
       hora = formatohora2.parse(horaFormateada);
       System.out.println("LA HORA DEFINITIVA EN LA B.D ES: "+fechaa);
       }
       catch (ParseException ex){
       ex.printStackTrace();
       }
//---------------------------- 
       gerente.getIdgerente();
       
       //viaje.setIdgerente()
       //viaje.setIdgerente(idusuario);
         viaje.setIdgerente(viajEJB.fijarIdGerente(idusuario));
         viaje.setFechaviaje(fechaa);
         viaje.setHorasalida(hora);
         viaje.setDestino(viajEJB.fijarDestino(destinoprueba));
       System.out.println("entro al metodo"); 
    if (viajEJB.crearviaje(viaje)==true) {
        mensaje= "Viaje creado exitosamente!";
    }
    else {
        mensaje="Viaje No Creado!";
    }   
    
    return mostrarlistarViajes();
    
    }
    
    public void setDestinoCiudad(ArrayList<SelectItem> destinoCiudad) {
        this.destinoCiudad = destinoCiudad;
    }
    
    public ArrayList<SelectItem> getDestinoCiudad() {
        Ciudad ciudadDestino=new Ciudad();
        ciudades=new ArrayList<Ciudad>(); //vamos a crear la lista de viajes
        ciudades=ciuEJB.obtenerCiudades();
        destinoCiudad=new ArrayList<SelectItem>();
        
        for(int j=0; j<ciudades.size(); j++){
            
            ciudadDestino=ciudades.get(j);
            destinoCiudad.add(new SelectItem(ciudadDestino.getNombre(), ciudadDestino.getNombre()));
        }
        
        return destinoCiudad;
    }
    
    /*public String cuadrarFecha(){
        try {
            Date fecha=viaje.getFechaviaje();
            SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
            String fechaFormateada = formato.format(fecha);
            
        } catch (NullPointerException e) {
            System.out.println("nada de nada");
        }
        
        return fechaFormateada;
         }*/
        
    
    
    //----------------------------      
       /*SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
       String fechaFormateada = formato.format(date1);
       System.out.println("LA FECHA FORMATEADA ES: "+fechaFormateada);
       
       SimpleDateFormat formato2 = new SimpleDateFormat("dd/MM/yyyy");
       Date fechaa=null;
       
       try{
       fechaa = formato2.parse(fechaFormateada);
       System.out.println("LA FECHA DEFINITIVA EN LA B.D ES: "+fechaa);
       }
       catch (ParseException ex){
       ex.printStackTrace();
       }*/
//---------------------------- 
      /*public List<Viaje> traerViajeEmpresa(){
        
        short idgeren=empresaprueba; //viaje.getIdgerente(); agarro el id del gerente  
        viajes= new ArrayList<Viaje>();
        viajes= viajEJB.recuperarDestino(idgeren); 
        
            
          
       
       viaje.getDestino(viajEJB.recuperarDestino(idgeren));
       vuelo.setDestino(vuelEJB.fijarDestino(destino));
        
    if (vuelEJB.crearVuelo(vuelo) == true) {
        mensaje= "Vuelo creado exitosamente";
        }
    else {
        mensaje="Vuelo No Creado";
    }   
    return "formCreateVuelo.xhtml";
    
    }*/
    //------------contructor-----------

    /**
     * Creates a new instance of TerminalMB
     */
    
    public String irMenuAdmin(){
        return "menuGerente.xhtml";
    }
    public TerminalMB() {
        
        gerente = new Gerente();
    }
}
