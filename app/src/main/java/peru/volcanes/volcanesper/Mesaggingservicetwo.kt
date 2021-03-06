package peru.volcanes.volcanesper
import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.media.RingtoneManager
import android.net.Uri
import android.os.Build
import android.support.v4.app.NotificationCompat
import android.util.Log
import com.google.firebase.messaging.FirebaseMessaging
import com.google.firebase.messaging.FirebaseMessagingService
import com.google.firebase.messaging.RemoteMessage
import java.util.*

class Mesaggingservicetwo : FirebaseMessagingService() {

    companion object {
        private val TAG = Mesaggingservicetwo::class.java.simpleName
    }

    override fun onMessageReceived(remoteMessage: RemoteMessage?) {

        //FirebaseMessaging.getInstance().subscribeToTopic("VOLCANESPERU30015")

        val valor3: String? = remoteMessage!!.getData().get("cuerpo")
        val valorextraido: String = valor3!!.split("&")[0]
        val volcan: String = valor3!!.split("&")[1]
        val tipodevento: String = valor3!!.split("&")[2]
        val fecha: String = valor3!!.split("&")[3]
        val hora: String = valor3!!.split("&")[4]
        val observaciones: String = valor3!!.split("&")[5]
        val simulacro: String = valor3!!.split("&")[6]
        val horautc: String = valor3!!.split("&")[7]

        if (valorextraido.equals("n01")){
            enviarnotificaciondatosalertalahar(remoteMessage.getData().get("cuerpo"));
        }
        else if(valorextraido.equals("n02")){
            enviarnotificaciondatosreporteextraordinario(remoteMessage.getData().get("cuerpo"));
        }
        else if(valorextraido.equals("n03")){
            sendNotificationalertadecenizas(remoteMessage.getData().get("cuerpo"));
        }
        else if(valorextraido.equals("n04")){
            enviarnotificaciondatosreporteordinario(remoteMessage.getData().get("cuerpo"));
        }
        else{
            enviarnotificaciondatosalertalahar(remoteMessage.getData().get("cuerpo"));
        }
    }

    private fun sendNotification(remoteMessage: String?) {
        val valor: String = remoteMessage!!.split("&")[0];
        val intent = Intent(this, LosdatosMainActivity::class.java)
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
        intent.putExtra("NOTIFICACIONDATA", valor);
        val pendingIntent = PendingIntent.getActivity(this, 0, intent, PendingIntent.FLAG_ONE_SHOT)
        val channelId = getString(R.string.default_notification_channel_id)
        val channelName = getString(R.string.default_notification_channel_name)
        val notificationBuilder = NotificationCompat.Builder(this, channelId)
                .setSmallIcon(R.mipmap.ic_launcher)
                .setContentTitle(valor)
                .setContentText(valor)
                .setAutoCancel(true)
                .setSound(RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION))
                .setContentIntent(pendingIntent)
        val notificationManager = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val channel = NotificationChannel(channelId, channelName, NotificationManager.IMPORTANCE_HIGH)
            notificationManager.createNotificationChannel(channel)
        }
        notificationManager.notify(0, notificationBuilder.build())
    }

    private fun enviarnotificaciondatosalertalahar(remoteMessage: String?) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val tiponotificacion2: String = remoteMessage!!.split("&")[0]
            val volcan: String = remoteMessage!!.split("&")[1]
            val tipodevento: String = remoteMessage!!.split("&")[2]
            val fecha: String = remoteMessage!!.split("&")[3]
            val hora: String = remoteMessage!!.split("&")[4]
            val horautc: String = remoteMessage!!.split("&")[5]
            val observaciones: String = remoteMessage!!.split("&")[6]
            val simulacro: String = remoteMessage!!.split("&")[7]
            val asubstring = fecha.substring(0, 10)
            var nobrevolcan_r2: String

            if (volcan == "1493157379002") {
                nobrevolcan_r2 = "Volcán Ubinas"
            } else if (volcan == "1493157381161") {
                nobrevolcan_r2 = "Volcán Sabancaya"
            } else if (volcan == "1506454510537") {
                nobrevolcan_r2 = "Volcán Sara Sara"
            } else if (volcan == "1506455245814") {
                nobrevolcan_r2 = "Volcán Cerro Auquihuato"
            } else if (volcan == "1506455248101") {
                nobrevolcan_r2 = "Volcán Andahua"
            } else if (volcan == "1506455249661") {
                nobrevolcan_r2 = "Volcán Coropuna"
            } else if (volcan == "1506455251429") {
                nobrevolcan_r2 = "Volcán Huambo"
            } else if (volcan == "1506455253382") {
                nobrevolcan_r2 = "Volcán Chachani"
            } else if (volcan == "1506455254838") {
                nobrevolcan_r2 = "Volcán Tutupaca"
            } else if (volcan == "1506455256229") {
                nobrevolcan_r2 = "Volcán Huaynaputina"
            } else if (volcan == "1506455257749") {
                nobrevolcan_r2 = "Volcán Ticsani"
            } else if (volcan == "1506455257753") {
                nobrevolcan_r2 = "Volcán Casiri"
            } else if (volcan == "1506455257755") {
                nobrevolcan_r2 = "Volcán Cerros Purupuruni"
            } else if (volcan == "1506455257757") {
                nobrevolcan_r2 = "Volcán Quimsachata"
            } else if (volcan == "1506455259126") {
                nobrevolcan_r2 = "Volcán Yucamane"
            } else if (volcan == "1506455259128") {
                nobrevolcan_r2 = "Volcán Misti"
            } else {
                nobrevolcan_r2 = "Volcán"
            }

            val defaultSoundUri = Uri.parse("android.resource://" + packageName + "/" + R.raw.beep2)
                  //  .setSound(RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION))

            val intent = Intent(this, Alertadatoslahar::class.java)
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
            intent.putExtra("NOTIFICACIONDATA", remoteMessage)
            val pendingIntent = PendingIntent.getActivity(this, 0, intent, PendingIntent.FLAG_ONE_SHOT)
            val channelId = getString(R.string.default_notification_channel_id_lahar)
            val channelName = getString(R.string.default_notification_channel_name_lahar)
            val notificationBuilder = NotificationCompat.Builder(this, channelId)
                    .setSmallIcon(R.mipmap.ic_launcher)
                    .setContentTitle("Alerta de Lahar")
                    .setContentText(" $nobrevolcan_r2  $asubstring | $hora ")
                    .setAutoCancel(true)
                    .setSound(defaultSoundUri)
                    .setContentIntent(pendingIntent)
            val notificationManager = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                val channel = NotificationChannel(channelId, channelName, NotificationManager.IMPORTANCE_HIGH)
                notificationManager.createNotificationChannel(channel)
            }
            val random = Random()
            notificationManager.notify(random.nextInt(100), notificationBuilder.build())
        }
        else {
            val tiponotificacion2: String = remoteMessage!!.split("&")[0]
            val volcan: String = remoteMessage!!.split("&")[1]
            val tipodevento: String = remoteMessage!!.split("&")[2]
            val fecha: String = remoteMessage!!.split("&")[3]
            val hora: String = remoteMessage!!.split("&")[4]
            val horautc: String = remoteMessage!!.split("&")[5]
            val observaciones: String = remoteMessage!!.split("&")[6]
            val simulacro: String = remoteMessage!!.split("&")[7]

            val asubstring = fecha.substring(0, 10)
            var nobrevolcan_r2: String
            if (volcan == "1493157379002") {
                nobrevolcan_r2 = "Volcán Ubinas"
            } else if (volcan == "1493157381161") {
                nobrevolcan_r2 = "Volcán Sabancaya"
            } else if (volcan == "1506454510537") {
                nobrevolcan_r2 = "Volcán Sara Sara"
            } else if (volcan == "1506455245814") {
                nobrevolcan_r2 = "Volcán Cerro Auquihuato"
            } else if (volcan == "1506455248101") {
                nobrevolcan_r2 = "Volcán Andahua"
            } else if (volcan == "1506455249661") {
                nobrevolcan_r2 = "Volcán Coropuna"
            } else if (volcan == "1506455251429") {
                nobrevolcan_r2 = "Volcán Huambo"
            } else if (volcan == "1506455253382") {
                nobrevolcan_r2 = "Volcán Chachani"
            } else if (volcan == "1506455254838") {
                nobrevolcan_r2 = "Volcán Tutupaca"
            } else if (volcan == "1506455256229") {
                nobrevolcan_r2 = "Volcán Huaynaputina"
            } else if (volcan == "1506455257749") {
                nobrevolcan_r2 = "Volcán Ticsani"
            } else if (volcan == "1506455257753") {
                nobrevolcan_r2 = "Volcán Casiri"
            } else if (volcan == "1506455257755") {
                nobrevolcan_r2 = "Volcán Cerros Purupuruni"
            } else if (volcan == "1506455257757") {
                nobrevolcan_r2 = "Volcán Quimsachata"
            } else if (volcan == "1506455259126") {
                nobrevolcan_r2 = "Volcán Yucamane"
            } else if (volcan == "1506455259128") {
                nobrevolcan_r2 = "Volcán Misti"
            } else {
                nobrevolcan_r2 = "Volcán"
            }

            val defaultSoundUri = Uri.parse("android.resource://" + packageName + "/" + R.raw.beep2)


            val intent = Intent(this, Alertadatoslahar::class.java)
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
            intent.putExtra("NOTIFICACIONDATA", remoteMessage);
            val pendingIntent = PendingIntent.getActivity(this, 0 /* Request code */, intent,
                    PendingIntent.FLAG_ONE_SHOT)

           // val defaultSoundUri = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION)
            val notificationBuilder = NotificationCompat.Builder(this)
                    .setContentTitle("Alerta de Lahar")
                    .setContentText(" $nobrevolcan_r2  $asubstring | $hora ")
                    .setAutoCancel(true)
                    .setSmallIcon(R.mipmap.ic_launcher)
                    .setSound(defaultSoundUri)
                    .setContentIntent(pendingIntent)
            val notificationManager = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
            val random = Random()
            notificationManager.notify(random.nextInt(100), notificationBuilder.build())
        }
    }

    private fun sendNotificationalertadecenizas(remoteMessage: String?) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val tiponotificacion2: String = remoteMessage!!.split("&")[0]
            val volcan: String = remoteMessage!!.split("&")[1]
            val pueblos: String = remoteMessage!!.split("&")[2]
            val tipodevento: String = remoteMessage!!.split("&")[3]
            val direccion: String = remoteMessage!!.split("&")[4]
            val radio:String = remoteMessage!!.split("&")[5]
            val fecha: String = remoteMessage!!.split("&")[6]
            val hora: String = remoteMessage!!.split("&")[7]
            val recomendaciones: String = remoteMessage!!.split("&")[8]
            val observaciones: String = remoteMessage!!.split("&")[9]
            val simulacro: String = remoteMessage!!.split("&")[10]
            val horautc: String = remoteMessage!!.split("&")[11]
            val asubstring = fecha.substring(0, 10)
            var nobrevolcan_r2: String

            if (volcan == "1493157379002") {
                nobrevolcan_r2 = "Volcán Ubinas"
            } else if (volcan == "1493157381161") {
                nobrevolcan_r2 = "Volcán Sabancaya"
            } else if (volcan == "1506454510537") {
                nobrevolcan_r2 = "Volcán Sara Sara"
            } else if (volcan == "1506455245814") {
                nobrevolcan_r2 = "Volcán Cerro Auquihuato"
            } else if (volcan == "1506455248101") {
                nobrevolcan_r2 = "Volcán Andahua"
            } else if (volcan == "1506455249661") {
                nobrevolcan_r2 = "Volcán Coropuna"
            } else if (volcan == "1506455251429") {
                nobrevolcan_r2 = "Volcán Huambo"
            } else if (volcan == "1506455253382") {
                nobrevolcan_r2 = "Volcán Chachani"
            } else if (volcan == "1506455254838") {
                nobrevolcan_r2 = "Volcán Tutupaca"
            } else if (volcan == "1506455256229") {
                nobrevolcan_r2 = "Volcán Huaynaputina"
            } else if (volcan == "1506455257749") {
                nobrevolcan_r2 = "Volcán Ticsani"
            } else if (volcan == "1506455257753") {
                nobrevolcan_r2 = "Volcán Casiri"
            } else if (volcan == "1506455257755") {
                nobrevolcan_r2 = "Volcán Cerros Purupuruni"
            } else if (volcan == "1506455257757") {
                nobrevolcan_r2 = "Volcán Quimsachata"
            } else if (volcan == "1506455259126") {
                nobrevolcan_r2 = "Volcán Yucamane"
            } else if (volcan == "1506455259128") {
                nobrevolcan_r2 = "Volcán Misti"
            } else {
                nobrevolcan_r2 = "Volcán"
            }

            val defaultSoundUri = Uri.parse("android.resource://" + packageName + "/" + R.raw.beep2)

               //     .setSound(RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION))

            val intent = Intent(this, Alertando::class.java)
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
            intent.putExtra("NOTIFICACIONDATA", remoteMessage)
            val pendingIntent = PendingIntent.getActivity(this, 0, intent, PendingIntent.FLAG_ONE_SHOT)
            val channelId = getString(R.string.default_notification_channel_id)
            val channelName = getString(R.string.default_notification_channel_name)
            val notificationBuilder = NotificationCompat.Builder(this, channelId)
                    .setSmallIcon(R.mipmap.ic_launcher)
                    .setContentTitle("Alerta de Cenizas")
                    .setContentText(" $nobrevolcan_r2  $asubstring | $hora ")
                    .setAutoCancel(true)
                    .setSound(defaultSoundUri)
                    .setContentIntent(pendingIntent)
            val notificationManager = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                val channel = NotificationChannel(channelId, channelName, NotificationManager.IMPORTANCE_HIGH)
                notificationManager.createNotificationChannel(channel)
            }
            val random = Random()
            notificationManager.notify(random.nextInt(100), notificationBuilder.build())
        }

        else {
            val tiponotificacion2: String = remoteMessage!!.split("&")[0]
            val volcan: String = remoteMessage!!.split("&")[1]
            val pueblos: String = remoteMessage!!.split("&")[2]
            val tipodevento: String = remoteMessage!!.split("&")[3]
            val direccion: String = remoteMessage!!.split("&")[4]
            val radio:String = remoteMessage!!.split("&")[5]
            val fecha: String = remoteMessage!!.split("&")[6]
            val hora: String = remoteMessage!!.split("&")[7]
            val recomendaciones: String = remoteMessage!!.split("&")[8]
            val observaciones: String = remoteMessage!!.split("&")[9]
            val simulacro: String = remoteMessage!!.split("&")[10]
            val horautc: String = remoteMessage!!.split("&")[11]
            val asubstring = fecha.substring(0, 10)
            var nobrevolcan_r2: String
            if (volcan == "1493157379002") {
                 nobrevolcan_r2 = "Volcán Ubinas"
            } else if (volcan == "1493157381161") {
                nobrevolcan_r2 = "Volcán Sabancaya"
            } else if (volcan == "1506454510537") {
                nobrevolcan_r2 = "Volcán Sara Sara"
            } else if (volcan == "1506455245814") {
                nobrevolcan_r2 = "Volcán Cerro Auquihuato"
            } else if (volcan == "1506455248101") {
                nobrevolcan_r2 = "Volcán Andahua"
            } else if (volcan == "1506455249661") {
                nobrevolcan_r2 = "Volcán Coropuna"
            } else if (volcan == "1506455251429") {
                nobrevolcan_r2 = "Volcán Huambo"
            } else if (volcan == "1506455253382") {
                nobrevolcan_r2 = "Volcán Chachani"
            } else if (volcan == "1506455254838") {
                nobrevolcan_r2 = "Volcán Tutupaca"
            } else if (volcan == "1506455256229") {
                nobrevolcan_r2 = "Volcán Huaynaputina"
            } else if (volcan == "1506455257749") {
                nobrevolcan_r2 = "Volcán Ticsani"
            } else if (volcan == "1506455257753") {
                nobrevolcan_r2 = "Volcán Casiri"
            } else if (volcan == "1506455257755") {
                nobrevolcan_r2 = "Volcán Cerros Purupuruni"
            } else if (volcan == "1506455257757") {
                nobrevolcan_r2 = "Volcán Quimsachata"
            } else if (volcan == "1506455259126") {
                nobrevolcan_r2 = "Volcán Yucamane"
            } else if (volcan == "1506455259128") {
                nobrevolcan_r2 = "Volcán Misti"
            } else {
                nobrevolcan_r2 = "Volcán"
            }

            val defaultSoundUri = Uri.parse("android.resource://" + packageName + "/" + R.raw.beep2)


            val intent = Intent(this, Alertando::class.java)
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
            intent.putExtra("NOTIFICACIONDATA", remoteMessage);
            val pendingIntent = PendingIntent.getActivity(this, 0 /* Request code */, intent,
                    PendingIntent.FLAG_ONE_SHOT)
            //val defaultSoundUri = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION)
            val notificationBuilder = NotificationCompat.Builder(this)
                    .setContentTitle("Alerta de Cenizas")
                    .setContentText(" $nobrevolcan_r2  $asubstring | $hora ")
                    .setAutoCancel(true)
                    .setSmallIcon(R.mipmap.ic_launcher)
                    .setSound(defaultSoundUri)
                    .setContentIntent(pendingIntent)
            val notificationManager = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
            val random = Random()
            notificationManager.notify(random.nextInt(100), notificationBuilder.build())

        }

    }

    private fun enviarnotificaciondatosreporteextraordinario(remoteMessage: String?) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {

            val tiponotificacion2: String = remoteMessage!!.split("&")[0]
            val volcan: String = remoteMessage!!.split("&")[1]
            val fecha: String = remoteMessage!!.split("&")[2]
            val hora: String = remoteMessage!!.split("&")[3]
            val simulacro: String = remoteMessage!!.split("&")[4]
            val horautc: String = remoteMessage!!.split("&")[5]
            val reportepdf: String = remoteMessage!!.split("&")[6]
            val coloralerta: String = remoteMessage!!.split("&")[7]
            val analisis: String = remoteMessage!!.split("&")[8]
            val conclusiones: String = remoteMessage!!.split("&")[9]

            val asubstring = fecha.substring(0, 10)
            var nobrevolcan_r2: String

            if (volcan == "1493157379002") {
                nobrevolcan_r2 = "Volcán Ubinas"
            } else if (volcan == "1493157381161") {
                nobrevolcan_r2 = "Volcán Sabancaya"
            } else if (volcan == "1506454510537") {
                nobrevolcan_r2 = "Volcán Sara Sara"
            } else if (volcan == "1506455245814") {
                nobrevolcan_r2 = "Volcán Cerro Auquihuato"
            } else if (volcan == "1506455248101") {
                nobrevolcan_r2 = "Volcán Andahua"
            } else if (volcan == "1506455249661") {
                nobrevolcan_r2 = "Volcán Coropuna"
            } else if (volcan == "1506455251429") {
                nobrevolcan_r2 = "Volcán Huambo"
            } else if (volcan == "1506455253382") {
                nobrevolcan_r2 = "Volcán Chachani"
            } else if (volcan == "1506455254838") {
                nobrevolcan_r2 = "Volcán Tutupaca"
            } else if (volcan == "1506455256229") {
                nobrevolcan_r2 = "Volcán Huaynaputina"
            } else if (volcan == "1506455257749") {
                nobrevolcan_r2 = "Volcán Ticsani"
            } else if (volcan == "1506455257753") {
                nobrevolcan_r2 = "Volcán Casiri"
            } else if (volcan == "1506455257755") {
                nobrevolcan_r2 = "Volcán Cerros Purupuruni"
            } else if (volcan == "1506455257757") {
                nobrevolcan_r2 = "Volcán Quimsachata"
            } else if (volcan == "1506455259126") {
                nobrevolcan_r2 = "Volcán Yucamane"
            } else if (volcan == "1506455259128") {
                nobrevolcan_r2 = "Volcán Misti"
            } else {
                nobrevolcan_r2 = "Volcán"
            }
            val defaultSoundUri = Uri.parse("android.resource://" + packageName + "/" + R.raw.beep2)

            val intent = Intent(this, Alertareporteactividad::class.java)
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
            intent.putExtra("NOTIFICACIONDATA", remoteMessage)
            val pendingIntent = PendingIntent.getActivity(this, 0, intent, PendingIntent.FLAG_ONE_SHOT)
            val channelId = getString(R.string.default_notification_channel_id)
            val channelName = getString(R.string.default_notification_channel_name)
            val notificationBuilder = NotificationCompat.Builder(this, channelId)
                    .setSmallIcon(R.mipmap.ic_launcher)
                    .setContentTitle("Reporte Extraordinario")
                    .setContentText(" $nobrevolcan_r2  $asubstring | $hora ")
                    .setAutoCancel(true)
                    .setSound(defaultSoundUri)
                    .setContentIntent(pendingIntent)
            val notificationManager = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                val channel = NotificationChannel(channelId, channelName, NotificationManager.IMPORTANCE_HIGH)
                notificationManager.createNotificationChannel(channel)
            }
            val random = Random()
            notificationManager.notify(random.nextInt(100), notificationBuilder.build())
        }

        else {
            val tiponotificacion2: String = remoteMessage!!.split("&")[0]
            val volcan: String = remoteMessage!!.split("&")[1]
            val fecha: String = remoteMessage!!.split("&")[2]
            val hora: String = remoteMessage!!.split("&")[3]
            val simulacro: String = remoteMessage!!.split("&")[4]
            val horautc: String = remoteMessage!!.split("&")[5]
            val reportepdf: String = remoteMessage!!.split("&")[6]
            val coloralerta: String = remoteMessage!!.split("&")[7]
            val analisis: String = remoteMessage!!.split("&")[8]
            val conclusiones: String = remoteMessage!!.split("&")[9]

            val asubstring = fecha.substring(0, 10)
            var nobrevolcan_r2: String
            if (volcan == "1493157379002") {
                nobrevolcan_r2 = "Volcán Ubinas"
            } else if (volcan == "1493157381161") {
                nobrevolcan_r2 = "Volcán Sabancaya"
            } else if (volcan == "1506454510537") {
                nobrevolcan_r2 = "Volcán Sara Sara"
            } else if (volcan == "1506455245814") {
                nobrevolcan_r2 = "Volcán Cerro Auquihuato"
            } else if (volcan == "1506455248101") {
                nobrevolcan_r2 = "Volcán Andahua"
            } else if (volcan == "1506455249661") {
                nobrevolcan_r2 = "Volcán Coropuna"
            } else if (volcan == "1506455251429") {
                nobrevolcan_r2 = "Volcán Huambo"
            } else if (volcan == "1506455253382") {
                nobrevolcan_r2 = "Volcán Chachani"
            } else if (volcan == "1506455254838") {
                nobrevolcan_r2 = "Volcán Tutupaca"
            } else if (volcan == "1506455256229") {
                nobrevolcan_r2 = "Volcán Huaynaputina"
            } else if (volcan == "1506455257749") {
                nobrevolcan_r2 = "Volcán Ticsani"
            } else if (volcan == "1506455257753") {
                nobrevolcan_r2 = "Volcán Casiri"
            } else if (volcan == "1506455257755") {
                nobrevolcan_r2 = "Volcán Cerros Purupuruni"
            } else if (volcan == "1506455257757") {
                nobrevolcan_r2 = "Volcán Quimsachata"
            } else if (volcan == "1506455259126") {
                nobrevolcan_r2 = "Volcán Yucamane"
            } else if (volcan == "1506455259128") {
                nobrevolcan_r2 = "Volcán Misti"
            } else {
                nobrevolcan_r2 = "Volcán"
            }

            val defaultSoundUri = Uri.parse("android.resource://" + packageName + "/" + R.raw.beep2)



            val intent = Intent(this, Alertareporteactividad::class.java)
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
            intent.putExtra("NOTIFICACIONDATA", remoteMessage);
            val pendingIntent = PendingIntent.getActivity(this, 0 /* Request code */, intent,
                    PendingIntent.FLAG_ONE_SHOT)
            //val defaultSoundUri = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION)

           //val defaultSoundUri = Uri.parse("android.resource://" + packageName + "/" + R.raw.beep2)

            val notificationBuilder = NotificationCompat.Builder(this)
                    .setContentTitle("Reporte Extraordinario")
                    .setContentText(" $nobrevolcan_r2  $asubstring | $hora ")
                    .setAutoCancel(true)
                    .setSmallIcon(R.mipmap.ic_launcher)
                    .setSound(defaultSoundUri)
                    .setContentIntent(pendingIntent)
            val notificationManager = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
            val random = Random()
            notificationManager.notify(random.nextInt(100), notificationBuilder.build())

        }

    }




    private fun enviarnotificaciondatosreporteordinario(remoteMessage: String?) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {

            val tiponotificacion2: String = remoteMessage!!.split("&")[0]
            val volcan: String = remoteMessage!!.split("&")[1]
            val fecha: String = remoteMessage!!.split("&")[2]
            val hora: String = remoteMessage!!.split("&")[3]
            val simulacro: String = remoteMessage!!.split("&")[4]
            val horautc: String = remoteMessage!!.split("&")[5]
            val reportepdf: String = remoteMessage!!.split("&")[6]
            val coloralerta: String = remoteMessage!!.split("&")[7]
            val analisis: String = remoteMessage!!.split("&")[8]
            val conclusiones: String = remoteMessage!!.split("&")[9]

           // val fecha_subs = fecha.substring(0, 10)

            val asubstring = fecha.substring(0, 10)
            var nobrevolcan_r2: String

            if (volcan == "1493157379002") {
                nobrevolcan_r2 = "Volcán Ubinas"
            } else if (volcan == "1493157381161") {
                nobrevolcan_r2 = "Volcán Sabancaya"
            } else if (volcan == "1506454510537") {
                nobrevolcan_r2 = "Volcán Sara Sara"
            } else if (volcan == "1506455245814") {
                nobrevolcan_r2 = "Volcán Cerro Auquihuato"
            } else if (volcan == "1506455248101") {
                nobrevolcan_r2 = "Volcán Andahua"
            } else if (volcan == "1506455249661") {
                nobrevolcan_r2 = "Volcán Coropuna"
            } else if (volcan == "1506455251429") {
                nobrevolcan_r2 = "Volcán Huambo"
            } else if (volcan == "1506455253382") {
                nobrevolcan_r2 = "Volcán Chachani"
            } else if (volcan == "1506455254838") {
                nobrevolcan_r2 = "Volcán Tutupaca"
            } else if (volcan == "1506455256229") {
                nobrevolcan_r2 = "Volcán Huaynaputina"
            } else if (volcan == "1506455257749") {
                nobrevolcan_r2 = "Volcán Ticsani"
            } else if (volcan == "1506455257753") {
                nobrevolcan_r2 = "Volcán Casiri"
            } else if (volcan == "1506455257755") {
                nobrevolcan_r2 = "Volcán Cerros Purupuruni"
            } else if (volcan == "1506455257757") {
                nobrevolcan_r2 = "Volcán Quimsachata"
            } else if (volcan == "1506455259126") {
                nobrevolcan_r2 = "Volcán Yucamane"
            } else if (volcan == "1506455259128") {
                nobrevolcan_r2 = "Volcán Misti"
            } else {
                nobrevolcan_r2 = "Volcán"
            }


            val defaultSoundUri = Uri.parse("android.resource://" + packageName + "/" + R.raw.beep2)


            val intent = Intent(this, Alertareporteactividad::class.java)
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
            intent.putExtra("NOTIFICACIONDATA", remoteMessage)
            val pendingIntent = PendingIntent.getActivity(this, 0, intent, PendingIntent.FLAG_ONE_SHOT)
            val channelId = getString(R.string.default_notification_channel_id)
            val channelName = getString(R.string.default_notification_channel_name)
            val notificationBuilder = NotificationCompat.Builder(this, channelId)
                    .setSmallIcon(R.mipmap.ic_launcher)
                    .setContentTitle("Reporte Ordinario")
                    .setContentText(" $nobrevolcan_r2  $asubstring | $hora ")
                    .setAutoCancel(true)
                    .setSound(defaultSoundUri)
                    .setContentIntent(pendingIntent)
            val notificationManager = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                val channel = NotificationChannel(channelId, channelName, NotificationManager.IMPORTANCE_HIGH)
                notificationManager.createNotificationChannel(channel)
            }
            val random = Random()
            notificationManager.notify(random.nextInt(100), notificationBuilder.build())
        }

        else {



            val tiponotificacion2: String = remoteMessage!!.split("&")[0]
            val volcan: String = remoteMessage!!.split("&")[1]
            val fecha: String = remoteMessage!!.split("&")[2]
            val hora: String = remoteMessage!!.split("&")[3]
            val simulacro: String = remoteMessage!!.split("&")[4]
            val horautc: String = remoteMessage!!.split("&")[5]
            val reportepdf: String = remoteMessage!!.split("&")[6]
            val coloralerta: String = remoteMessage!!.split("&")[7]
            val analisis: String = remoteMessage!!.split("&")[8]
            val conclusiones: String = remoteMessage!!.split("&")[9]

            val asubstring = fecha.substring(0, 10)
            var nobrevolcan_r2: String
            if (volcan == "1493157379002") {
                nobrevolcan_r2 = "Volcán Ubinas"
            } else if (volcan == "1493157381161") {
                nobrevolcan_r2 = "Volcán Sabancaya"
            } else if (volcan == "1506454510537") {
                nobrevolcan_r2 = "Volcán Sara Sara"
            } else if (volcan == "1506455245814") {
                nobrevolcan_r2 = "Volcán Cerro Auquihuato"
            } else if (volcan == "1506455248101") {
                nobrevolcan_r2 = "Volcán Andahua"
            } else if (volcan == "1506455249661") {
                nobrevolcan_r2 = "Volcán Coropuna"
            } else if (volcan == "1506455251429") {
                nobrevolcan_r2 = "Volcán Huambo"
            } else if (volcan == "1506455253382") {
                nobrevolcan_r2 = "Volcán Chachani"
            } else if (volcan == "1506455254838") {
                nobrevolcan_r2 = "Volcán Tutupaca"
            } else if (volcan == "1506455256229") {
                nobrevolcan_r2 = "Volcán Huaynaputina"
            } else if (volcan == "1506455257749") {
                nobrevolcan_r2 = "Volcán Ticsani"
            } else if (volcan == "1506455257753") {
                nobrevolcan_r2 = "Volcán Casiri"
            } else if (volcan == "1506455257755") {
                nobrevolcan_r2 = "Volcán Cerros Purupuruni"
            } else if (volcan == "1506455257757") {
                nobrevolcan_r2 = "Volcán Quimsachata"
            } else if (volcan == "1506455259126") {
                nobrevolcan_r2 = "Volcán Yucamane"
            } else if (volcan == "1506455259128") {
                nobrevolcan_r2 = "Volcán Misti"
            } else {
                nobrevolcan_r2 = "Volcán"
            }


            val defaultSoundUri = Uri.parse("android.resource://" + packageName + "/" + R.raw.beep2)


            val intent = Intent(this, Alertareporteactividad::class.java)
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
            intent.putExtra("NOTIFICACIONDATA", remoteMessage);
            val pendingIntent = PendingIntent.getActivity(this, 0 /* Request code */, intent,
                    PendingIntent.FLAG_ONE_SHOT)
           // val defaultSoundUri = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION)
            val notificationBuilder = NotificationCompat.Builder(this)
                    .setContentTitle("Reporte Ordinario")
                    .setContentText(" $nobrevolcan_r2  $asubstring | $hora ")
                    .setAutoCancel(true)
                    .setSmallIcon(R.mipmap.ic_launcher)
                    .setSound(defaultSoundUri)
                    .setContentIntent(pendingIntent)
            val notificationManager = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
            val random = Random()
            notificationManager.notify(random.nextInt(100), notificationBuilder.build())
        }
    }
}

