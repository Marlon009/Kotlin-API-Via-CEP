package br.edu.fatecpg
import okhttp3.OkHttpClient
import okhttp3.Request
import com.google.gson.Gson
import java.io.IOException

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
fun main() {
    //criação de um cliente http.
    val client = OkHttpClient()

    // Recebe valores a entrada do usuario, e caso ele não digite nada, será considerado um espaço vazio.
    print("Digite o CEP desejado: ")
    val cep = readLine() ?:" "

    //requisição
    val url = "https://viacep.com.br/ws/$cep/json/"

    //Construção da requisição http.
    val request = Request.Builder()
        .url(url)
        .build()

    client.newCall(request).execute().use { response ->
        if (!response.isSuccessful) throw IOException("Houve um erro inesperado: %response")

        val responseBody = response.body?.string()?: ""
        val endereco = Gson().fromJson(responseBody, Endereco::class.java)

        print(endereco)
    }

}