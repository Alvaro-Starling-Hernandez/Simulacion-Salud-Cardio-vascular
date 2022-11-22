package com.example.simulaconcardiovascular.utils

sealed class Screen(val route: String){

    object Diagnostico: Screen("Diagnostico")

    object RegistroContacto: Screen("RegistroTecnico"){
        const val id = "id"
    }
    object ConsultaContacto: Screen("ConsultaContacto")

    fun withArgs(vararg args: String): String {
        return buildString {
            append(route)
            args.forEach{ arg ->
                append("/$arg")
            }
        }
    }

    fun withArgsFormat(vararg args: String) : String {
        return buildString {
            append(route)
            args.forEach{ arg ->
                append("/{$arg}")
            }
        }
    }
}
