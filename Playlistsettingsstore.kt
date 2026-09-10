package id.drnet.streamtv.util

import android.content.Context

/**
 * Penyimpanan URL playlist M3U kustom (opsional) - kalau diisi, dipakai
 * MENGGANTIKAN AppConfig.DEFAULT_PLAYLIST_URL untuk device ini saja. Kalau
 * kosong/null, otomatis balik ke default (playlist DRNET dari GitHub).
 *
 * Berguna untuk pelanggan yang mau pakai link M3U dari provider IPTV lain
 * (bukan channel list DRNET), atau buat uji coba playlist tertentu.
 */
class PlaylistSettingsStore(context: Context) {

    private val prefs = context.applicationContext
        .getSharedPreferences("streamtv_playlist_settings", Context.MODE_PRIVATE)

    var customPlaylistUrl: String?
        get() = prefs.getString(KEY_CUSTOM_URL, null)?.takeIf { it.isNotBlank() }
        set(value) = prefs.edit().putString(KEY_CUSTOM_URL, value).apply()

    fun resetToDefault() {
        customPlaylistUrl = null
    }

    companion object {
        private const val KEY_CUSTOM_URL = "https://iptv-org.github.io/iptv/index.m3u"
    }
}
