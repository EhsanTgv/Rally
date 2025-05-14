package com.example.compose.rally

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AttachMoney
import androidx.compose.material.icons.filled.MoneyOff
import androidx.compose.material.icons.filled.PieChart
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.vector.ImageVector
import com.example.compose.rally.data.UserData
import com.example.compose.rally.ui.accounts.AccountsScreen
import com.example.compose.rally.ui.bills.BillsScreen
import com.example.compose.rally.ui.overview.OverviewScreen

enum class RallyScreen(
    val icon: ImageVector,
    private val body: @Composable ((RallyScreen) -> Unit) -> Unit
) {
    Overview(
        icon = Icons.Filled.PieChart,
        body = { onScreenChange -> OverviewScreen() }
    ),
    Accounts(
        icon = Icons.Filled.AttachMoney,
        body = { AccountsScreen() }
    ),
    Bills(
        icon = Icons.Filled.MoneyOff,
        body = { BillsScreen(UserData.bills) }
    );

    @Composable
    fun content(onScreenChange: (RallyScreen) -> Unit) {
        body(onScreenChange)
    }
}