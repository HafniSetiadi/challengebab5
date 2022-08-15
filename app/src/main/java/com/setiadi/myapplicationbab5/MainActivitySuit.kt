package com.setiadi.myapplicationbab5

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.setiadi.myapplicationbab5.databinding.ActivityMainSuitBinding

class MainActivitySuit : AppCompatActivity() {
    private var binding: ActivityMainSuitBinding? = null
    private var pemain2: String? = null
    private var pemain1: String? = null
    private var layout: ActivityMainSuitBinding? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_suit)

        layout = ActivityMainSuitBinding.inflate(layoutInflater)
        setContentView(layout?.root)

        binding = ActivityMainSuitBinding.inflate(layoutInflater)
        setContentView(binding?.root)

        resetGame()
        aktifkanButton()
        nonaktifkanButton()

        binding?.ivBatuDipilih?.setOnClickListener {
            game("Batu")
            binding?.ivBatuDipilih?.setBackgroundColor(resources.getColor(R.color.gray))

            val dialog = AlertDialog.Builder(this)
            dialog.setTitle("Hasil Permainan")
            dialog.setMessage("")

            dialog.setCancelable(false)
            dialog.setPositiveButton("Main Lagi") { dialogInterface, p1 ->}
            dialog.setNegativeButton("Kembali Ke Menu") { dialogInterface, p1 -> }
            dialog.setNeutralButton("Tutup") { dialog,view ->
                dialog.dismiss()}
            dialog.show()

        }
        binding?.ivKertasDipilih?.setOnClickListener {
            game("Kertas")
            binding?.ivKertasDipilih?.setBackgroundColor(resources.getColor(R.color.gray))
        }
        binding?.ivGuntingDipilih?.setOnClickListener {
            game("Gunting")
            binding?.ivGuntingDipilih?.setBackgroundColor(resources.getColor(R.color.gray))
        }
        binding?.ibReset?.setOnClickListener {
            resetGame()
        }
    }
    /*
    Dibuat aktif dan tdk utk hindari spamming
   */
    private fun aktifkanButton() {
        binding?.ivBatuDipilih?.isClickable = true
        binding?.ivKertasDipilih?.isClickable = true
        binding?.ivGuntingDipilih?.isClickable = true
        binding?.ivBatuC?.isClickable = true
        binding?.ivKertasC?.isClickable = true
        binding?.ivGuntingC?.isClickable = true

    }
    private fun nonaktifkanButton() {
        binding?.ivBatuDipilih?.isClickable = false
        binding?.ivKertasDipilih?.isClickable = false
        binding?.ivGuntingDipilih?.isClickable = false
        binding?.ivBatuC?.isClickable = false
        binding?.ivKertasC?.isClickable = false
        binding?.ivGuntingC?.isClickable = false
    }
    /*
    Start Bermain: Pilihan suit pertama di eksekusi oleh Human.
    */
    private fun game(pemain1: String) {
        binding?.textView?.text = tentukanPemenang(pemain1, randomComputer())
    }
    /*
    Komputasi acak utk pemain computer
    */
    private fun randomComputer(): String {
        val pilihan = listOf("Batu", "Gunting", "Kertas")
        val pilih = pilihan.random()

        binding?.textComputer?.text = pilih

        if (pilih.equals("Batu")){
            binding?.ivBatuC?.setBackgroundColor(resources.getColor(R.color.gray))}
        else if (pilih.equals("Gunting")){
            binding?.ivGuntingC?.setBackgroundColor(resources.getColor(R.color.gray))}
        else if (pilih.equals ("Kertas")){
            binding?.ivKertasC?.setBackgroundColor(resources.getColor(R.color.gray))}

        return pilih
    }
    /*
    Logic utk kriteria pemenang permainan
    */
    private fun tentukanPemenang(pemain1: String, pemain2: String): String {
        val result = when (pemain1) {
            "Gunting" -> when (pemain2) {
                "Gunting" -> "Result Draw"
                "Batu" -> "Pemain 2 Menang"
                "Kertas" -> "Pemain 1 Menang"
                else -> "Input Error"
            }
            "Batu" -> when (pemain2) {
                "Batu" -> "Result Draw"
                "Gunting" -> "Pemain 1 Menang"
                "Kertas" -> "Pemain 2 Menang"
                else -> "Input Error"
            }
            "Kertas" -> when (pemain2) {
                "Kertas" -> "Result Draw"
                "Gunting" -> "Pemain 2 Menang"
                "Batu" -> "Pemain 1 Menang"
                else -> "Input Error"
            }
            else -> "Input Error"
        }
        if(result.equals("Result Draw")){
            binding?.ivStatus?.setImageResource(R.drawable.fontdraw)}
        else if(result.equals("Pemain 1 Menang")){
            binding?.ivStatus?.setImageResource(R.drawable.fontpemain1menang)}
        else if(result.equals("Pemain 2 Menang")) {
            binding?.ivStatus?.setImageResource(R.drawable.fontpemain2menang)}

        Log.d("gamesuitactity", "Pemain1: " + pemain1)
        Log.d("gamesuitactity", "Pemain2: " + pemain2)
        Log.d("gamesuitactity", "Result: " + result)
        return result
    }

    private fun resetGame() {
        binding?.textView?.text = "Permainan Suit Jepang"
        binding?.textComputer?.text = ""
        binding?.ivBatuDipilih?.setBackgroundColor(resources.getColor(R.color.white))
        binding?.ivKertasDipilih?.setBackgroundColor(resources.getColor(R.color.white))
        binding?.ivGuntingDipilih?.setBackgroundColor(resources.getColor(R.color.white))
        binding?.ivBatuC?.setBackgroundColor(resources.getColor(R.color.white))
        binding?.ivKertasC?.setBackgroundColor(resources.getColor(R.color.white))
        binding?.ivGuntingC?.setBackgroundColor(resources.getColor(R.color.white))
        binding?.ivStatus?.setImageResource(R.drawable.fontvs)

    }
}
