package br.edu.fatecpg

data class Endereco (
    val cep : String,
    val logradouro : String,
    val complemento: String,
    val unidade: String,
    val bairro: String,
    val localidade: String,
    val uf: String,
    val ibge: Int,
    val ddd: Int,
    val siafi: Int,
){


    override fun toString(): String {
        return """
            Endereço:
            CEP: $cep
            Logradouro: $logradouro
            Complemento: $complemento
            Unidade: $unidade
            Bairro: $bairro
            Localidade: $localidade
            UF: $uf
            IBGE: $ibge
            DDD: $ddd
            Siafi: $siafi
            """.trimIndent()

    }
}