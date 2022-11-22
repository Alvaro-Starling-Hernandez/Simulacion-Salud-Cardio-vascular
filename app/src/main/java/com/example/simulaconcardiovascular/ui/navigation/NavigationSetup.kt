package com.example.simulaconcardiovascular.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.example.simulaconcardiovascular.ui.screens.contacto.ContactoConsultaScreen
import com.example.simulaconcardiovascular.ui.screens.contacto.ContactoRegistroScreen
import com.example.simulaconcardiovascular.ui.screens.diagnostico.DiagnosticoScreen
import com.example.simulaconcardiovascular.utils.Screen

@Composable
fun NavigationSetup(navController: NavHostController) {
    NavHost(navController, startDestination = Screen.Diagnostico.route) {
        composable(BottomNavItem.Home.route) {
            DiagnosticoScreen(navController)
        }
        composable(BottomNavItem.Contacto.route) {
            ContactoConsultaScreen(navController)
        }
        composable(Screen.RegistroContacto.route) {
            ContactoRegistroScreen(navController, 0)
        }
        composable(
            Screen.RegistroContacto.withArgsFormat(Screen.RegistroContacto.id),
            arguments = listOf(navArgument(Screen.RegistroContacto.id) { type = NavType.IntType })
        ) { backStackEntry ->
            backStackEntry.arguments?.getInt(Screen.RegistroContacto.id)?.let {
                ContactoRegistroScreen(
                    navController,
                    backStackEntry.arguments?.getInt(Screen.RegistroContacto.id)!!
                )
            }
        }
    }
}


