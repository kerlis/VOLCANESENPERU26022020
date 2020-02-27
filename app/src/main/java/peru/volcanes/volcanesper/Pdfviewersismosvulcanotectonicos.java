package peru.volcanes.volcanesper;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.customtabs.CustomTabsCallback;
import android.support.customtabs.CustomTabsClient;
import android.support.customtabs.CustomTabsIntent;
import android.support.customtabs.CustomTabsServiceConnection;
import android.support.customtabs.CustomTabsSession;
import android.support.design.widget.NavigationView;
import android.support.v4.app.FragmentActivity;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.SlidingDrawer;
import android.widget.TextView;
import android.widget.Toast;
import peru.volcanes.volcanesper.m_model.volcanes;
import com.github.barteksc.pdfviewer.PDFView;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class Pdfviewersismosvulcanotectonicos extends FragmentActivity implements NavigationView.OnNavigationItemSelectedListener {
    RelativeLayout informacion;
    RelativeLayout convenciones;
    TextView titulovolcanlabel;
    Button mk;
    RelativeLayout menuright;
    String fecha;
    String nombrereporte;
    String pdfurl;
    String codigovolcan;
    private DatabaseReference mFirebaseDatabase2;
    String glaciares_text;
    String sismogramaurls;
    String ubicacion;
    String fecha_actualizacion_d;
    String hora_actualizacion_d;
    String actividad_reciente_d;
    String altura_d;
    String codigo_d;
    String alertavolcanica_d;
    String diametro_crater_d;
    String estado_d;
    String glaciares_d;
    String imagen_d;
    String latitud_d;
    String longitud_d;
    String monitoreo_d;
    String nombre_d;
    String tipica_erupcion_d;
    String tipo_d;
    String ultima_erupcion_d;
    String camaraurl_d;
    String codigovolcan_v;
    String mapasismico;

    RelativeLayout bloque1;
    RelativeLayout bloque3a;
    RelativeLayout bloque4;
    RelativeLayout bloque5;
    RelativeLayout bloque6;
    RelativeLayout bloque7;
    TextView slideup;
    RelativeLayout options;
    SlidingDrawer slidingDrawer;
    TextView alertacenizas_text;
    TextView camara_text;
    TextView mapa_text;
    TextView trayectoria_cenizas_text;
    TextView trayectoria_cenizas_text2;
    TextView trayectoria_cenizas_text3;
    TextView camara;
    TextView mapa;
    TextView titulo_trayectorias;

    private String[] mNavigationDrawerItemTitles;
    private DrawerLayout mDrawerLayout;
    private ListView mDrawerList;
    private RelativeLayout mDrawerBlock;
    RelativeLayout blocke1a;
    RelativeLayout blocke2a;
    RelativeLayout blocke4a;
    RelativeLayout blocke5a;
    RelativeLayout blocke9;
    Toolbar toolbar;
    private CharSequence mDrawerTitle;
    private CharSequence mTitle;
    android.support.v7.app.ActionBarDrawerToggle mDrawerToggle;
    ImageView sliderz;
    private static final String TAG = Pdfviewersismosvulcanotectonicos.class.getSimpleName();
    PDFView pdfView;
    RelativeLayout blocke6a;
   // String proyeccionsenamhiurl;
    String proyecionsenahmi;
    RelativeLayout bloquenombre;
    RelativeLayout bloque62;
    TextView trayectoria_cenizas_text222;
    String proyeccionsenamhiurl;
    RelativeLayout bloque42;
    TextView camara2;
    RelativeLayout blocke12;
    private static final String CHROME_PACKAGE = "com.android.chrome";
    private CustomTabsServiceConnection ctConnection;
    private CustomTabsSession customTabsSession;
    RelativeLayout blocke92;

    String val;
    String menu1,menu2,menu3,menu4,menu5,menu6,menu7,menu8;
    LinearLayout pronostico_menu2;
    LinearLayout opciones72;
    LinearLayout pronostico_menu;
    LinearLayout sismogramas_menu;
    LinearLayout reportes_menu;
    LinearLayout alertas_menu;
    LinearLayout camara_menu ;
    LinearLayout mapasismic_menu;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_pdfviewersismosvulcanotectonicos);
        titulo_trayectorias = (TextView) findViewById(R.id.titulo_trayectorias);

        blocke1a = (RelativeLayout) findViewById(R.id.blocke1);
        blocke2a = (RelativeLayout) findViewById(R.id.blocke2);
        blocke4a = (RelativeLayout) findViewById(R.id.blocke4);
        blocke5a = (RelativeLayout) findViewById(R.id.blocke5);
        blocke6a = (RelativeLayout) findViewById(R.id.blocke6);


        blocke12 = (RelativeLayout) findViewById(R.id.blocke12);

        blocke92 = (RelativeLayout) findViewById(R.id.blocke92);


        blocke92.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View arg0) {
                Intent intent = new Intent(Pdfviewersismosvulcanotectonicos.this,Contactar.class);
                startActivity(intent);
            }
        });





        blocke12.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View arg0) {
                Intent intent = new Intent(Pdfviewersismosvulcanotectonicos.this,Ultimasnotificaciones.class);
                startActivity(intent);
            }
        });





        blocke1a.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View arg0) {
                Intent intent = new Intent(Pdfviewersismosvulcanotectonicos.this,pagedivisor.class);
                startActivity(intent);
            }
        });
        blocke2a.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View arg0) {
                Intent intent = new Intent(Pdfviewersismosvulcanotectonicos.this,Informacion.class);
                startActivity(intent);
            }
        });
        blocke4a.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View arg0) {
                Intent intent = new Intent(Pdfviewersismosvulcanotectonicos.this,Notificacionesconfig.class);
                startActivity(intent);
            }
        });
        blocke5a.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View arg0) {
                Intent intent = new Intent(Pdfviewersismosvulcanotectonicos.this,Convenciones.class);
                startActivity(intent);
            }
        });


        blocke9 = (RelativeLayout) findViewById(R.id.blocke9);
        blocke9.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View arg0) {
                Intent intent = new Intent(Pdfviewersismosvulcanotectonicos.this,Listadoredessociales.class);
                startActivity(intent);
            }
        });


        blocke6a.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View arg0) {
                Intent intent = new Intent(Intent.ACTION_MAIN);
                intent.addCategory(Intent.CATEGORY_HOME);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);
                finish();
            }
        });



        slideup = (TextView) findViewById(R.id.openslide);
        options = (RelativeLayout) findViewById(R.id.options);
        options.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                if (slidingDrawer.isOpened()) {
                    slidingDrawer.animateClose();
                } else {
                    slidingDrawer.animateOpen();
                }

            }
        });
        slidingDrawer = (SlidingDrawer) findViewById(R.id.slidingDrawer);
        slidingDrawer.setOnDrawerOpenListener(new SlidingDrawer.OnDrawerOpenListener() {
            @Override
            public void onDrawerOpened()
            {
            }
        });

        slidingDrawer.setOnDrawerCloseListener(new SlidingDrawer.OnDrawerCloseListener()
        {
            @Override
            public void onDrawerClosed()
            {
                slidingDrawer.setBackgroundColor(Color.TRANSPARENT);
            }
        });

        sliderz = (ImageView) findViewById(R.id.sliderz);
        mTitle = mDrawerTitle = getTitle();
        mNavigationDrawerItemTitles= getResources().getStringArray(R.array.navigation_drawer_items_array);
        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        mDrawerBlock = (RelativeLayout) findViewById(R.id.mDrawerBlock);
        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        mDrawerLayout.setDrawerListener(mDrawerToggle);
        setupDrawerToggle();
        sliderz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mDrawerLayout.openDrawer(GravityCompat.START);
            }
        });

        Typeface fontAwesomeFont = Typeface.createFromAsset(getAssets(), "fontawesome-webfont.ttf");


        camara2 = (TextView) findViewById(R.id.camara2);

        camara2.setTypeface(fontAwesomeFont);

        slideup = (TextView) findViewById(R.id.openslide);
        camara = (TextView) findViewById(R.id.camara);
        mapa = (TextView) findViewById(R.id.mapa);
        alertacenizas_text = (TextView) findViewById(R.id.alertacenizas_text);
        camara_text = (TextView) findViewById(R.id.camara_text);
        mapa_text = (TextView) findViewById(R.id.mapa_text);
        trayectoria_cenizas_text = (TextView) findViewById(R.id.trayectoria_cenizas_text);
        trayectoria_cenizas_text2 = (TextView) findViewById(R.id.trayectoria_cenizas_text2);
        trayectoria_cenizas_text3 = (TextView) findViewById(R.id.trayectoria_cenizas_text3);
        camara.setTypeface(fontAwesomeFont);
        mapa.setTypeface(fontAwesomeFont);
        slideup.setTypeface(fontAwesomeFont);
        Intent i=this.getIntent();
        fecha = i.getExtras().getString("FECHA");
        nombrereporte = i.getExtras().getString("NOMBRE");
        pdfurl = i.getExtras().getString("PDFURL");
        codigovolcan = i.getExtras().getString("CODIGOVOLCAN");
        Toast.makeText(this,pdfurl, Toast.LENGTH_SHORT).show();
        titulovolcanlabel = (TextView) findViewById(R.id.titulo_volcan_label);
        pdfView = (PDFView) findViewById(R.id.pdfView);
        new RetrevePDFStream().execute(pdfurl);
        detecta_volcan();
        mostrar_ult_volcan();

        bloque62 = (RelativeLayout) findViewById(R.id.bloque62);
        bloque42 = (RelativeLayout) findViewById(R.id.bloque42);


        /*
        bloque62.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openTab();
            }
        });
        bloque42.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openTabMapa();
            }
        });
        */

        bloque62.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setAction(Intent.ACTION_VIEW);
                intent.addCategory(Intent.CATEGORY_BROWSABLE);
                intent.setData(Uri.parse(proyeccionsenamhiurl));
                startActivity(intent);
            }
        });



/*
        bloque42.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openTabMapa();
            }
        });

*/


        bloque42.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setAction(Intent.ACTION_VIEW);
                intent.addCategory(Intent.CATEGORY_BROWSABLE);
                intent.setData(Uri.parse(mapasismico));
                startActivity(intent);
            }
        });

        menu_config();



    }


    /*-------------ver datos de volcan------------------------------------------------------*/
    public void detecta_volcan() {
        FirebaseDatabase.getInstance();
        final FirebaseDatabase database2 = FirebaseDatabase.getInstance();
        Intent i=this.getIntent();
        codigovolcan_v = i.getExtras().getString("CODIGOVOLCAN");
        mFirebaseDatabase2 = database2.getReference("actividadvolcanica").child("volcanes");
        mFirebaseDatabase2.keepSynced(true);
        mFirebaseDatabase2.orderByKey().equalTo(codigovolcan_v).addChildEventListener(new ChildEventListener() {
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                volcanes sreporte2 = dataSnapshot.getValue(volcanes.class);
                guardar_pref(sreporte2);
            }
            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String s) {
                volcanes sreporte2 = dataSnapshot.getValue(volcanes.class);
                guardar_pref(sreporte2);
            }
            @Override
            public void onChildRemoved(DataSnapshot dataSnapshot) {
                volcanes sreporte2 = dataSnapshot.getValue(volcanes.class);
                guardar_pref(sreporte2);
            }
            @Override
            public void onChildMoved(DataSnapshot dataSnapshot, String s) {
                volcanes sreporte2 = dataSnapshot.getValue(volcanes.class);
                guardar_pref(sreporte2);
            }
            @Override
            public void onCancelled(DatabaseError databaseError) {
            }
        });
    }
    public void guardar_pref(volcanes sreporte) {
        SharedPreferences prefs = getSharedPreferences("ultsismo", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = prefs.edit();
        editor.putString("actividad_reciente", sreporte.getActividadreciente());
        editor.putString("ubicacion", sreporte.getLatitud());
        editor.putString("fecha_actualizacion_dto", sreporte.getFechaactualizacion());
        editor.putString("hora_actualizacion_dto", sreporte.getHoraactualizacion());
        editor.putString("actividad_reciente_dto", sreporte.getActividadreciente());
        editor.putString("altura_dto", sreporte.getAltura());
        editor.putString("codigo_dto", sreporte.getCodigo());
        editor.putString("alertavolcanica_dto", sreporte.getAlertavolcanica());
        editor.putString("diametro_crater_dto", sreporte.getDiametrocrater());
        editor.putString("estado_dto", sreporte.getEstado());
        editor.putString("glaciares_dto", sreporte.getGlaciares());
        editor.putString("imagen_dto", sreporte.getImagen());
        editor.putString("latitud_dto", sreporte.getLatitud());
        editor.putString("longitud_dto", sreporte.getLongitud());
        editor.putString("monitoreo_dto", sreporte.getMonitoreo());
        editor.putString("nombre_dto", sreporte.getNombre());
        editor.putString("tipica_erupcion_dto", sreporte.getTipicaerupcion());
        editor.putString("tipo_dto", sreporte.getTipo());
        editor.putString("ultima_erupcion_dto", sreporte.getUltimaerupcion());
        editor.putString("camaraurl_dto", sreporte.getCamaraurl());
        editor.putString("sismogra", sreporte.getSismograma());
        editor.putString("mapasismico", sreporte.getMapasismico());
        editor.putString("proyeccionsenamhiurl", sreporte.getProyeccionsenamhiurl());

        editor.apply();
        mostrar_ult_volcan();
    }
    public void mostrar_ult_volcan() {
        SharedPreferences prefs = getSharedPreferences("ultsismo", Context.MODE_PRIVATE);
        ubicacion = prefs.getString("inubicacion", "");

        fecha_actualizacion_d = prefs.getString("fecha_actualizacion_dto", "");
        hora_actualizacion_d = prefs.getString("hora_actualizacion_dto", "");
        actividad_reciente_d = prefs.getString("actividad_reciente_dto", "");
        altura_d = prefs.getString("altura_dto", "");
        codigo_d = prefs.getString("codigo_dto", "");
        alertavolcanica_d = prefs.getString("alertavolcanica_dto", "");
        diametro_crater_d = prefs.getString("diametro_crater_dto", "");
        estado_d = prefs.getString("estado_dto", "");
        glaciares_d = prefs.getString("glaciares_dto", "");
        imagen_d = prefs.getString("imagen_dto", "");
        latitud_d = prefs.getString("latitud_dto", "");
        longitud_d = prefs.getString("longitud_dto", "");
        monitoreo_d = prefs.getString("monitoreo_dto", "");
        nombre_d = prefs.getString("nombre_dto", "");
        tipica_erupcion_d = prefs.getString("tipica_erupcion_dto", "");
        tipo_d = prefs.getString("tipo_dto", "");
        ultima_erupcion_d = prefs.getString("ultima_erupcion_dto", "");
        camaraurl_d = prefs.getString("camaraurl_dto", "");
        sismogramaurls = prefs.getString("sismogra", "");
        mapasismico = prefs.getString("mapasismico", "");

        proyeccionsenamhiurl = prefs.getString("proyeccionsenamhiurl", "");

        titulo_trayectorias.setText("Boletin n°" + nombrereporte +"\n" + "Volcan " + nombre_d );



        trayectoria_cenizas_text222 = (TextView) findViewById(R.id.trayectoria_cenizas_text222);
       // trayectoria_cenizas_text222.setText("Pronóstico de dispersión");
 /*--------VISUALIZACION DE MENU----------*/

         pronostico_menu2 = (LinearLayout) findViewById(R.id.opciones2);
         opciones72 = (LinearLayout) findViewById(R.id.opciones72);

         pronostico_menu = (LinearLayout) findViewById(R.id.opciones3);
         sismogramas_menu = (LinearLayout) findViewById(R.id.opciones4);
         reportes_menu = (LinearLayout) findViewById(R.id.opciones5);
         alertas_menu = (LinearLayout) findViewById(R.id.opciones6);
         camara_menu = (LinearLayout) findViewById(R.id.opciones7);
         mapasismic_menu = (LinearLayout) findViewById(R.id.opciones8);
         val = String.valueOf(codigo_d);


        /*
        if (val.equals("1493157379002")){
            opciones72.setVisibility(View.VISIBLE);
            pronostico_menu2.setVisibility(View.VISIBLE);
            pronostico_menu.setVisibility(View.GONE);
            sismogramas_menu.setVisibility(View.VISIBLE);
            reportes_menu.setVisibility(View.VISIBLE);
            alertas_menu.setVisibility(View.VISIBLE);
            camara_menu.setVisibility(View.VISIBLE);
            mapasismic_menu.setVisibility(View.GONE);
        }
        else if(val.equals("1493157381161")){
            opciones72.setVisibility(View.VISIBLE);
            pronostico_menu2.setVisibility(View.VISIBLE);
            pronostico_menu.setVisibility(View.GONE);
            sismogramas_menu.setVisibility(View.VISIBLE);
            reportes_menu.setVisibility(View.VISIBLE);
            alertas_menu.setVisibility(View.VISIBLE);
            camara_menu.setVisibility(View.VISIBLE);
            mapasismic_menu.setVisibility(View.GONE);
        }
        else if(val.equals("1506454510537")){
            opciones72.setVisibility(View.GONE);
            pronostico_menu2.setVisibility(View.GONE);
            pronostico_menu.setVisibility(View.GONE);
            sismogramas_menu.setVisibility(View.VISIBLE);
            reportes_menu.setVisibility(View.GONE);
            alertas_menu.setVisibility(View.GONE);
            camara_menu.setVisibility(View.VISIBLE);
            mapasismic_menu.setVisibility(View.GONE);
        }
        else if(val.equals("1506455245814")){
            opciones72.setVisibility(View.GONE);
            pronostico_menu2.setVisibility(View.GONE);
            pronostico_menu.setVisibility(View.GONE);
            sismogramas_menu.setVisibility(View.VISIBLE);
            reportes_menu.setVisibility(View.GONE);
            alertas_menu.setVisibility(View.GONE);
            camara_menu.setVisibility(View.GONE);
            mapasismic_menu.setVisibility(View.GONE);
        }
        else if(val.equals("1506455248101")){
            opciones72.setVisibility(View.GONE);
            pronostico_menu2.setVisibility(View.GONE);
            pronostico_menu.setVisibility(View.GONE);
            sismogramas_menu.setVisibility(View.GONE);
            reportes_menu.setVisibility(View.GONE);
            alertas_menu.setVisibility(View.GONE);
            camara_menu.setVisibility(View.GONE);
            mapasismic_menu.setVisibility(View.GONE);
        }
        else if(val.equals("1506455249661")){
            opciones72.setVisibility(View.GONE);
            pronostico_menu2.setVisibility(View.GONE);
            pronostico_menu.setVisibility(View.GONE);
            sismogramas_menu.setVisibility(View.VISIBLE);
            reportes_menu.setVisibility(View.VISIBLE);
            alertas_menu.setVisibility(View.GONE);
            camara_menu.setVisibility(View.VISIBLE);
            mapasismic_menu.setVisibility(View.GONE);
        }
        else if(val.equals("1506455251429")){
            opciones72.setVisibility(View.GONE);
            pronostico_menu2.setVisibility(View.GONE);
            pronostico_menu.setVisibility(View.GONE);
            sismogramas_menu.setVisibility(View.GONE);
            reportes_menu.setVisibility(View.GONE);
            alertas_menu.setVisibility(View.GONE);
            camara_menu.setVisibility(View.GONE);
            mapasismic_menu.setVisibility(View.GONE);
        }
        else if(val.equals("1506455253382")){
            opciones72.setVisibility(View.GONE);
            pronostico_menu2.setVisibility(View.GONE);
            pronostico_menu.setVisibility(View.GONE);
            sismogramas_menu.setVisibility(View.VISIBLE);
            reportes_menu.setVisibility(View.VISIBLE);
            alertas_menu.setVisibility(View.GONE);
            camara_menu.setVisibility(View.GONE);
            mapasismic_menu.setVisibility(View.GONE);
        }
        else if(val.equals("1506455254838")){
            opciones72.setVisibility(View.GONE);
            pronostico_menu2.setVisibility(View.GONE);
            pronostico_menu.setVisibility(View.GONE);
            sismogramas_menu.setVisibility(View.VISIBLE);
            reportes_menu.setVisibility(View.VISIBLE);
            alertas_menu.setVisibility(View.GONE);
            camara_menu.setVisibility(View.GONE);
            mapasismic_menu.setVisibility(View.GONE);
        }
        else if(val.equals("1506455256229")){
            opciones72.setVisibility(View.GONE);
            pronostico_menu2.setVisibility(View.GONE);
            pronostico_menu.setVisibility(View.GONE);
            sismogramas_menu.setVisibility(View.VISIBLE);
            reportes_menu.setVisibility(View.VISIBLE);
            alertas_menu.setVisibility(View.GONE);
            camara_menu.setVisibility(View.GONE);
            mapasismic_menu.setVisibility(View.GONE);
        }
        else if(val.equals("1506455257749")){
            opciones72.setVisibility(View.VISIBLE);
            pronostico_menu2.setVisibility(View.GONE);
            pronostico_menu.setVisibility(View.GONE);
            sismogramas_menu.setVisibility(View.VISIBLE);
            reportes_menu.setVisibility(View.VISIBLE);
            alertas_menu.setVisibility(View.GONE);
            camara_menu.setVisibility(View.VISIBLE);
            mapasismic_menu.setVisibility(View.GONE);
        }
        else if(val.equals("1506455257753")){
            opciones72.setVisibility(View.GONE);
            pronostico_menu2.setVisibility(View.GONE);
            pronostico_menu.setVisibility(View.GONE);
            sismogramas_menu.setVisibility(View.VISIBLE);
            reportes_menu.setVisibility(View.GONE);
            alertas_menu.setVisibility(View.GONE);
            camara_menu.setVisibility(View.GONE);
            mapasismic_menu.setVisibility(View.GONE);
        }
        else if(val.equals("1506455257755")){
            opciones72.setVisibility(View.GONE);
            pronostico_menu2.setVisibility(View.GONE);
            pronostico_menu.setVisibility(View.GONE);
            sismogramas_menu.setVisibility(View.GONE);
            reportes_menu.setVisibility(View.GONE);
            alertas_menu.setVisibility(View.GONE);
            camara_menu.setVisibility(View.GONE);
            mapasismic_menu.setVisibility(View.GONE);
        }
        else if(val.equals("1506455257757")){
            opciones72.setVisibility(View.GONE);
            pronostico_menu2.setVisibility(View.GONE);
            pronostico_menu.setVisibility(View.GONE);
            sismogramas_menu.setVisibility(View.GONE);
            reportes_menu.setVisibility(View.GONE);
            alertas_menu.setVisibility(View.GONE);
            camara_menu.setVisibility(View.GONE);
            mapasismic_menu.setVisibility(View.GONE);
        }
        else if(val.equals("1506455259126")){
            opciones72.setVisibility(View.GONE);
            pronostico_menu2.setVisibility(View.GONE);
            pronostico_menu.setVisibility(View.GONE);
            sismogramas_menu.setVisibility(View.VISIBLE);
            reportes_menu.setVisibility(View.VISIBLE);
            alertas_menu.setVisibility(View.GONE);
            camara_menu.setVisibility(View.VISIBLE);
            mapasismic_menu.setVisibility(View.GONE);
        }
        else if(val.equals("1506455259128")){
            opciones72.setVisibility(View.VISIBLE);
            pronostico_menu2.setVisibility(View.GONE);
            pronostico_menu.setVisibility(View.GONE);
            sismogramas_menu.setVisibility(View.VISIBLE);
            reportes_menu.setVisibility(View.VISIBLE);
            alertas_menu.setVisibility(View.GONE);
            camara_menu.setVisibility(View.VISIBLE);
            mapasismic_menu.setVisibility(View.GONE);
        }
        else{
            opciones72.setVisibility(View.GONE);
            pronostico_menu2.setVisibility(View.GONE);
            pronostico_menu.setVisibility(View.GONE);
            sismogramas_menu.setVisibility(View.VISIBLE);
            reportes_menu.setVisibility(View.VISIBLE);
            alertas_menu.setVisibility(View.VISIBLE);
            camara_menu.setVisibility(View.VISIBLE);
            mapasismic_menu.setVisibility(View.GONE);
        }
*/



     /*--------VISUALIZACION DE MENU----------*/

        bloque3a = (RelativeLayout) findViewById(R.id.bloque3);
        bloque5 = (RelativeLayout) findViewById(R.id.bloque5);
        bloque1 = (RelativeLayout) findViewById(R.id.bloque1);
        bloque6 = (RelativeLayout) findViewById(R.id.bloque6);
        bloque4 = (RelativeLayout) findViewById(R.id.bloque4);
        bloque7 = (RelativeLayout) findViewById(R.id.bloque7);

        bloque5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                slidingDrawer.animateClose();

                alerta_cenizas(actividad_reciente_d,
                        estado_d,
                        nombre_d,
                        ubicacion,
                        imagen_d,
                        altura_d,
                        codigo_d,
                        diametro_crater_d,
                        glaciares_text,
                        glaciares_d,
                        latitud_d,
                        longitud_d,
                        monitoreo_d,
                        tipo_d,
                        tipica_erupcion_d,
                        fecha_actualizacion_d,
                        hora_actualizacion_d,
                        alertavolcanica_d,
                        camaraurl_d,
                        sismogramaurls,
                        mapasismico,
                        proyeccionsenamhiurl
                );
            }
        });

        if (mapasismico.length() == 1) {
            //bloque1.setBackgroundColor(getResources().getColor(R.color.verdeigp));


            bloque1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    slidingDrawer.animateClose();
                    openmap2(actividad_reciente_d,
                            estado_d,
                            nombre_d,
                            ubicacion,
                            imagen_d,
                            altura_d,
                            codigo_d,
                            diametro_crater_d,
                            glaciares_text,
                            glaciares_d,
                            latitud_d,
                            longitud_d,
                            monitoreo_d,
                            tipo_d,
                            tipica_erupcion_d,
                            fecha_actualizacion_d,
                            hora_actualizacion_d,
                            alertavolcanica_d,
                            camaraurl_d,
                            sismogramaurls,
                            mapasismico,
                            proyeccionsenamhiurl);

                }
            });


        }
        else{
            bloque1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    slidingDrawer.animateClose();

                    openmap(actividad_reciente_d,
                            estado_d,
                            nombre_d,
                            ubicacion,
                            imagen_d,
                            altura_d,
                            codigo_d,
                            diametro_crater_d,
                            glaciares_text,
                            glaciares_d,
                            latitud_d,
                            longitud_d,
                            monitoreo_d,
                            tipo_d,
                            tipica_erupcion_d,
                            fecha_actualizacion_d,
                            hora_actualizacion_d,
                            alertavolcanica_d,
                            camaraurl_d,
                            sismogramaurls,
                            mapasismico,
                            proyeccionsenamhiurl);
                }
            });
        }


        bloque3a.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                slidingDrawer.animateClose();

                reportes(actividad_reciente_d,
                        estado_d,
                        nombre_d,
                        ubicacion,
                        imagen_d,
                        altura_d,
                        codigo_d,
                        diametro_crater_d,
                        glaciares_text,
                        glaciares_d,
                        latitud_d,
                        longitud_d,
                        monitoreo_d,
                        tipo_d,
                        tipica_erupcion_d,
                        fecha_actualizacion_d,
                        hora_actualizacion_d,
                        alertavolcanica_d,
                        camaraurl_d,
                        sismogramaurls,
                        mapasismico,
                        proyeccionsenamhiurl);
            }
        });

        bloque4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                slidingDrawer.animateClose();

                camara_web(actividad_reciente_d,
                        estado_d,
                        nombre_d,
                        ubicacion,
                        imagen_d,
                        altura_d,
                        codigo_d,
                        diametro_crater_d,
                        glaciares_text,
                        glaciares_d,
                        latitud_d,
                        longitud_d,
                        monitoreo_d,
                        tipo_d,
                        tipica_erupcion_d,
                        fecha_actualizacion_d,
                        hora_actualizacion_d,
                        alertavolcanica_d,
                        camaraurl_d,
                        sismogramaurls,
                        mapasismico,
                        proyeccionsenamhiurl);
            }
        });

        bloque6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                slidingDrawer.animateClose();

                openDetailActivity(actividad_reciente_d,
                        estado_d,
                        nombre_d,
                        ubicacion,
                        imagen_d,
                        altura_d,
                        codigo_d,
                        diametro_crater_d,
                        glaciares_text,
                        glaciares_d,
                        latitud_d,
                        longitud_d,
                        monitoreo_d,
                        tipo_d,
                        tipica_erupcion_d,
                        fecha_actualizacion_d,
                        hora_actualizacion_d,
                        alertavolcanica_d,
                        camaraurl_d,
                        sismogramaurls,
                        mapasismico,
                        proyeccionsenamhiurl);
            }
        });

        bloque7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                slidingDrawer.animateClose();

                sismograma_web(actividad_reciente_d,
                        estado_d,
                        nombre_d,
                        ubicacion,
                        imagen_d,
                        altura_d,
                        codigo_d,
                        diametro_crater_d,
                        glaciares_text,
                        glaciares_d,
                        latitud_d,
                        longitud_d,
                        monitoreo_d,
                        tipo_d,
                        tipica_erupcion_d,
                        fecha_actualizacion_d,
                        hora_actualizacion_d,
                        alertavolcanica_d,
                        camaraurl_d,
                        sismogramaurls,
                        mapasismico,
                        proyeccionsenamhiurl);
            }
        });
    }


    private void openDetailActivity(String...details) {
        Intent i=new Intent(Pdfviewersismosvulcanotectonicos.this,Dispersioncenizas.class);
        i.putExtra("ACTIVIDAD_RECIENTE",details[0]);
        i.putExtra("ESTADO",details[1]);
        i.putExtra("NOMBRES",details[2]);
        i.putExtra("UBICACION",details[3]);
        i.putExtra("URLIMAGEN",details[4]);
        i.putExtra("ALTURA",details[5]);
        i.putExtra("CODIGO",details[6]);
        i.putExtra("DIAMETRO",details[7]);
        i.putExtra("GLACIARES",details[8]);
        i.putExtra("IMAGEN",details[9]);
        i.putExtra("LATITUD",details[10]);
        i.putExtra("LONGITUD",details[11]);
        i.putExtra("MONITOREO",details[12]);
        i.putExtra("TIPO",details[13]);
        i.putExtra("TIPICA_ERUPCION",details[14]);
        i.putExtra("FECHAACTUALIZACION",details[15]);
        i.putExtra("HORAACTUALIZACION",details[16]);
        i.putExtra("ALERTA",details[17]);
        i.putExtra("CAMARAURL",details[18]);
        i.putExtra("SISMOGRAMA",details[19]);
        i.putExtra("MAPASISMICO",details[20]);

        i.putExtra("PROYECCIONSENAHMI",details[21]);


        Pdfviewersismosvulcanotectonicos.this.startActivity(i);
    }

    private void openmap(String...details)
    {
        Intent i=new Intent(Pdfviewersismosvulcanotectonicos.this,Sismosengeneral.class);
        i.putExtra("ACTIVIDAD_RECIENTE",details[0]);
        i.putExtra("ESTADO",details[1]);
        i.putExtra("NOMBRES",details[2]);
        i.putExtra("UBICACION",details[3]);
        i.putExtra("URLIMAGEN",details[4]);
        i.putExtra("ALTURA",details[5]);
        i.putExtra("CODIGO",details[6]);
        i.putExtra("DIAMETRO",details[7]);
        i.putExtra("GLACIARES",details[8]);
        i.putExtra("IMAGEN",details[9]);
        i.putExtra("LATITUD",details[10]);
        i.putExtra("LONGITUD",details[11]);
        i.putExtra("MONITOREO",details[12]);
        i.putExtra("TIPO",details[13]);
        i.putExtra("TIPICA_ERUPCION",details[14]);
        i.putExtra("FECHAACTUALIZACION",details[15]);
        i.putExtra("HORAACTUALIZACION",details[16]);
        i.putExtra("ALERTA",details[17]);
        i.putExtra("CAMARAURL",details[18]);
        i.putExtra("SISMOGRAMA",details[19]);
        i.putExtra("MAPASISMICO",details[20]);

        i.putExtra("PROYECCIONSENAHMI",details[21]);


        Pdfviewersismosvulcanotectonicos.this.startActivity(i);
    }


    private void openmap2(String...details)
    {
        Intent i=new Intent(Pdfviewersismosvulcanotectonicos.this,sismosengeneralgoogle.class);
        i.putExtra("ACTIVIDAD_RECIENTE",details[0]);
        i.putExtra("ESTADO",details[1]);
        i.putExtra("NOMBRES",details[2]);
        i.putExtra("UBICACION",details[3]);
        i.putExtra("URLIMAGEN",details[4]);
        i.putExtra("ALTURA",details[5]);
        i.putExtra("CODIGO",details[6]);
        i.putExtra("DIAMETRO",details[7]);
        i.putExtra("GLACIARES",details[8]);
        i.putExtra("IMAGEN",details[9]);
        i.putExtra("LATITUD",details[10]);
        i.putExtra("LONGITUD",details[11]);
        i.putExtra("MONITOREO",details[12]);
        i.putExtra("TIPO",details[13]);
        i.putExtra("TIPICA_ERUPCION",details[14]);
        i.putExtra("FECHAACTUALIZACION",details[15]);
        i.putExtra("HORAACTUALIZACION",details[16]);
        i.putExtra("ALERTA",details[17]);
        i.putExtra("CAMARAURL",details[18]);
        i.putExtra("SISMOGRAMA",details[19]);
        i.putExtra("MAPASISMICO",details[20]);

        i.putExtra("PROYECCIONSENAHMI",details[21]);

        Pdfviewersismosvulcanotectonicos.this.startActivity(i);
    }


    private void alerta_cenizas(String...details) {
        Intent i=new Intent(Pdfviewersismosvulcanotectonicos.this,Reportesalertascenizastwo.class);
        i.putExtra("ACTIVIDAD_RECIENTE",details[0]);
        i.putExtra("ESTADO",details[1]);
        i.putExtra("NOMBRES",details[2]);
        i.putExtra("UBICACION",details[3]);
        i.putExtra("URLIMAGEN",details[4]);
        i.putExtra("ALTURA",details[5]);
        i.putExtra("CODIGO",details[6]);
        i.putExtra("DIAMETRO",details[7]);
        i.putExtra("GLACIARES",details[8]);
        i.putExtra("IMAGEN",details[9]);
        i.putExtra("LATITUD",details[10]);
        i.putExtra("LONGITUD",details[11]);
        i.putExtra("MONITOREO",details[12]);
        i.putExtra("TIPO",details[13]);
        i.putExtra("TIPICA_ERUPCION",details[14]);
        i.putExtra("FECHAACTUALIZACION",details[15]);
        i.putExtra("HORAACTUALIZACION",details[16]);
        i.putExtra("ALERTA",details[17]);
        i.putExtra("CAMARAURL",details[18]);
        i.putExtra("SISMOGRAMA",details[19]);
        i.putExtra("MAPASISMICO",details[20]);

        i.putExtra("PROYECCIONSENAHMI",details[21]);


        Pdfviewersismosvulcanotectonicos.this.startActivity(i);
    }

    private void camara_web(String...details) {
        Intent i=new Intent(Pdfviewersismosvulcanotectonicos.this,Volcancamara.class);
        i.putExtra("ACTIVIDAD_RECIENTE",details[0]);
        i.putExtra("ESTADO",details[1]);
        i.putExtra("NOMBRES",details[2]);
        i.putExtra("UBICACION",details[3]);
        i.putExtra("URLIMAGEN",details[4]);
        i.putExtra("ALTURA",details[5]);
        i.putExtra("CODIGO",details[6]);
        i.putExtra("DIAMETRO",details[7]);
        i.putExtra("GLACIARES",details[8]);
        i.putExtra("IMAGEN",details[9]);
        i.putExtra("LATITUD",details[10]);
        i.putExtra("LONGITUD",details[11]);
        i.putExtra("MONITOREO",details[12]);
        i.putExtra("TIPO",details[13]);
        i.putExtra("TIPICA_ERUPCION",details[14]);
        i.putExtra("FECHAACTUALIZACION",details[15]);
        i.putExtra("HORAACTUALIZACION",details[16]);
        i.putExtra("ALERTA",details[17]);
        i.putExtra("CAMARAURL",details[18]);
        i.putExtra("SISMOGRAMA",details[19]);
        i.putExtra("MAPASISMICO",details[20]);

        i.putExtra("PROYECCIONSENAHMI",details[21]);


        Pdfviewersismosvulcanotectonicos.this.startActivity(i);
    }

    private void sismograma_web(String...details) {
        Intent i=new Intent(Pdfviewersismosvulcanotectonicos.this,Sismogramas.class);
        i.putExtra("ACTIVIDAD_RECIENTE",details[0]);
        i.putExtra("ESTADO",details[1]);
        i.putExtra("NOMBRES",details[2]);
        i.putExtra("UBICACION",details[3]);
        i.putExtra("URLIMAGEN",details[4]);
        i.putExtra("ALTURA",details[5]);
        i.putExtra("CODIGO",details[6]);
        i.putExtra("DIAMETRO",details[7]);
        i.putExtra("GLACIARES",details[8]);
        i.putExtra("IMAGEN",details[9]);
        i.putExtra("LATITUD",details[10]);
        i.putExtra("LONGITUD",details[11]);
        i.putExtra("MONITOREO",details[12]);
        i.putExtra("TIPO",details[13]);
        i.putExtra("TIPICA_ERUPCION",details[14]);
        i.putExtra("FECHAACTUALIZACION",details[15]);
        i.putExtra("HORAACTUALIZACION",details[16]);
        i.putExtra("ALERTA",details[17]);
        i.putExtra("CAMARAURL",details[18]);
        i.putExtra("SISMOGRAMA",details[19]);
        i.putExtra("MAPASISMICO",details[20]);

        i.putExtra("PROYECCIONSENAHMI",details[21]);


        Pdfviewersismosvulcanotectonicos.this.startActivity(i);
    }

    private void reportes(String...details) {
        Intent i=new Intent(Pdfviewersismosvulcanotectonicos.this,Reportesdeactividad.class);
        i.putExtra("ACTIVIDAD_RECIENTE",details[0]);
        i.putExtra("ESTADO",details[1]);
        i.putExtra("NOMBRES",details[2]);
        i.putExtra("UBICACION",details[3]);
        i.putExtra("URLIMAGEN",details[4]);
        i.putExtra("ALTURA",details[5]);
        i.putExtra("CODIGO",details[6]);
        i.putExtra("DIAMETRO",details[7]);
        i.putExtra("GLACIARES",details[8]);
        i.putExtra("IMAGEN",details[9]);
        i.putExtra("LATITUD",details[10]);
        i.putExtra("LONGITUD",details[11]);
        i.putExtra("MONITOREO",details[12]);
        i.putExtra("TIPO",details[13]);
        i.putExtra("TIPICA_ERUPCION",details[14]);
        i.putExtra("FECHAACTUALIZACION",details[15]);
        i.putExtra("HORAACTUALIZACION",details[16]);
        i.putExtra("ALERTA",details[17]);
        i.putExtra("CAMARAURL",details[18]);
        i.putExtra("SISMOGRAMA",details[19]);
        i.putExtra("MAPASISMICO",details[20]);

        i.putExtra("PROYECCIONSENAHMI",details[21]);


        Pdfviewersismosvulcanotectonicos.this.startActivity(i);
    }













    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (ctConnection != null) {
            unbindService(ctConnection);
        }
    }

    private CustomTabsSession getSession(CustomTabsClient customTabsClient) {
        if (customTabsClient != null) {
            return customTabsClient.newSession(new CustomTabsCallback() {
        /*@Override
        public void onNavigationEvent(int navigationEvent, Bundle extras) {
          super.onNavigationEvent(navigationEvent, extras);
        }*/
            });
        }
        return null;
    }



    public void openTab() {
        CustomTabsIntent.Builder builder = new CustomTabsIntent.Builder(customTabsSession);
        builder.setToolbarColor(ContextCompat.getColor(this, R.color.azulbackground));
        builder.setShowTitle(true);
        builder.setCloseButtonIcon(BitmapFactory.decodeResource(getResources(),
                R.drawable.ic_launcher5));
      //  builder.addMenuItem(getString(R.string.menu1), createIntent(R.string.menu1, 1));
      //  builder.addMenuItem(getString(R.string.menu2), createIntent(R.string.menu2, 2));
        Bitmap icon = BitmapFactory.decodeResource(getResources(), R.drawable.ic_launcher5);
        //  ic_launcherigp  android.R.drawable.ic_menu_add

        builder.setActionButton(icon, getString(R.string.action), createIntent(R.string.action, 3),
                true);
        CustomTabsIntent customTabsIntent = builder.build();
        customTabsIntent.launchUrl(this, Uri.parse(proyeccionsenamhiurl));
    }

    public void openTabMapa() {
        CustomTabsIntent.Builder builder = new CustomTabsIntent.Builder(customTabsSession);
        builder.setToolbarColor(ContextCompat.getColor(this, R.color.azulbackground));
        builder.setShowTitle(true);
        builder.setCloseButtonIcon(BitmapFactory.decodeResource(getResources(),
                R.drawable.ic_launcher5));
     //   builder.addMenuItem(getString(R.string.menu1), createIntent(R.string.menu1, 1));
     //   builder.addMenuItem(getString(R.string.menu2), createIntent(R.string.menu2, 2));
        Bitmap icon = BitmapFactory.decodeResource(getResources(), R.drawable.ic_launcher5);
        //  ic_launcherigp  android.R.drawable.ic_menu_add

        builder.setActionButton(icon, getString(R.string.action), createIntent(R.string.action, 3),
                true);
        CustomTabsIntent customTabsIntent = builder.build();
        customTabsIntent.launchUrl(this, Uri.parse(mapasismico));
    }

    private PendingIntent createIntent(int text, int number) {
        Intent intent = new Intent(this, CustomTabsBroadcastReceiver.class);
        intent.putExtra("text", getString(text));
        return PendingIntent.getBroadcast(this, number, intent, 0);
    }





    class RetrevePDFStream extends AsyncTask<String, Void, InputStream> {
        @Override
        protected InputStream doInBackground(String... strings) {
            InputStream inputStream = null;
            try{
                URL url = new URL(strings[0]);
                HttpURLConnection urlConnection = (HttpURLConnection)url.openConnection();
                if (urlConnection.getResponseCode() == 200){
                    inputStream =  new BufferedInputStream(urlConnection.getInputStream());
              }
            }
            catch(IOException e){
                return null;
            }
            return  inputStream;
        }
        @Override
        protected void onPostExecute(InputStream inputStream) {
          pdfView.fromStream(inputStream).load();
        }
    }
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        return false;
    }
    void setupDrawerToggle(){
        mDrawerToggle = new android.support.v7.app.ActionBarDrawerToggle(this,mDrawerLayout,toolbar,R.string.app_name, R.string.app_name);
        mDrawerToggle.syncState();
    }

    private void menu_config() {
        DatabaseReference mDatabase;
        mDatabase = FirebaseDatabase.getInstance().getReference();
        mDatabase.keepSynced(true);
        mDatabase.child("actividadvolcanica").child("volcanes").child(val).child("menu").orderByKey().limitToLast(1).addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                Menudeopciones sreporte = dataSnapshot.getValue(Menudeopciones.class);
                guardar_pref(sreporte);
            }
            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String s) {
                Menudeopciones sreporte = dataSnapshot.getValue(Menudeopciones.class);
                guardar_pref(sreporte);
            }
            @Override
            public void onChildRemoved(DataSnapshot dataSnapshot) {
                Menudeopciones sreporte = dataSnapshot.getValue(Menudeopciones.class);
                guardar_pref(sreporte);
            }
            @Override
            public void onChildMoved(DataSnapshot dataSnapshot, String s) {
                Menudeopciones sreporte = dataSnapshot.getValue(Menudeopciones.class);
                guardar_pref(sreporte);
            }
            @Override
            public void onCancelled(DatabaseError databaseError) {
            }
        });
    }

    private void guardar_pref(Menudeopciones sreporte) {
        SharedPreferences prefs = getSharedPreferences("ultsismo", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = prefs.edit();
        editor.putString("menu1", sreporte.getMenu1());
        editor.putString("menu2", sreporte.getMenu2());
        editor.putString("menu3", sreporte.getMenu3());
        editor.putString("menu4", sreporte.getMenu4());
        editor.putString("menu5", sreporte.getMenu5());
        editor.putString("menu6", sreporte.getMenu6());
        editor.putString("menu7", sreporte.getMenu7());
        editor.putString("menu8", sreporte.getMenu8());
        editor.apply();
        mostrar_menu();
    }

    private void mostrar_menu() {
        SharedPreferences prefs = getSharedPreferences("ultsismo", Context.MODE_PRIVATE);
        menu1 = prefs.getString("menu1", "");
        menu2 = prefs.getString("menu2", "");
        menu3 = prefs.getString("menu3", "");
        menu4 = prefs.getString("menu4", "");
        menu5 = prefs.getString("menu5", "");
        menu6 = prefs.getString("menu6", "");
        menu7 = prefs.getString("menu7", "");
        menu8 = prefs.getString("menu8", "");

        if(menu1.equals("VISIBLE")){
            opciones72.setVisibility(View.VISIBLE);
        }
        else{
            opciones72.setVisibility(View.GONE);
        }

        if(menu2.equals("VISIBLE")){
            pronostico_menu2.setVisibility(View.VISIBLE);
        }
        else{
            pronostico_menu2.setVisibility(View.GONE);
        }

        if(menu3.equals("VISIBLE")){
            pronostico_menu.setVisibility(View.VISIBLE);
        }
        else{
            pronostico_menu.setVisibility(View.GONE);
        }

        if(menu4.equals("VISIBLE")){
            sismogramas_menu.setVisibility(View.VISIBLE);
        }
        else{
            sismogramas_menu.setVisibility(View.GONE);
        }

        if(menu5.equals("VISIBLE")){
            reportes_menu.setVisibility(View.VISIBLE);
        }
        else{
            reportes_menu.setVisibility(View.GONE);
        }

        if(menu6.equals("VISIBLE")){
            alertas_menu.setVisibility(View.VISIBLE);
        }
        else{
            alertas_menu.setVisibility(View.GONE);
        }

        if(menu7.equals("VISIBLE")){
            camara_menu.setVisibility(View.VISIBLE);
        }
        else{
            camara_menu.setVisibility(View.GONE);
        }

        if(menu8.equals("VISIBLE")){
            mapasismic_menu.setVisibility(View.VISIBLE);
        }
        else{
            mapasismic_menu.setVisibility(View.GONE);
        }
    }



}