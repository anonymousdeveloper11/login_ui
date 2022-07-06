package com.anonymousdeveloper11.jetpacklogin.ui

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.anonymousdeveloper11.jetpacklogin.R
import com.anonymousdeveloper11.jetpacklogin.ui.theme.darkBlue

@Preview(showSystemUi = true)
@Composable
fun SigninScreen(){

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        Title()
        Email()
        Password()
        SigninButton()
    }
}

@Composable
fun SigninButton() {
  Button(onClick = { },
  modifier = Modifier.fillMaxWidth(),
      contentPadding = PaddingValues(16.dp),
      colors = ButtonDefaults.buttonColors(
          backgroundColor = darkBlue,
          contentColor = Color.White
      )

  ) {

      Text( 
          text = stringResource(id = R.string.sign_in) )
  }
}

@Composable
fun Password() {
    val passwordState = remember {
        mutableStateOf(TextFieldValue())
    }
    val showPassword = remember {
        mutableStateOf(false)
    }
    TextField(
        modifier = Modifier.fillMaxWidth(),
        value = passwordState.value,
        onValueChange ={passwordState.value = it},
    label = { Text(text = stringResource(id = R.string.password_hint))},
    colors = TextFieldDefaults.textFieldColors(
        focusedIndicatorColor = Color.Transparent,
        unfocusedIndicatorColor = Color.Transparent
    ),
    shape = RoundedCornerShape(8.dp),
        visualTransformation = if(showPassword.value){
            VisualTransformation.None
        }else{
            PasswordVisualTransformation()

        },
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
        trailingIcon = {
            if(showPassword.value){
                IconButton(onClick = {showPassword.value = false }) {
                    Icon(imageVector =Icons.Filled.Visibility ,
                        contentDescription = stringResource(id = R.string.hide_password) )
                }

                }else{
                    IconButton(onClick = {showPassword.value = true  }) {
                        Icon(imageVector = Icons.Filled.VisibilityOff,
                            contentDescription = stringResource(id = R.string.show_password))

                    }
            }

        }

        )
}

@Composable
fun Email() {
    val emailState = remember { mutableStateOf(TextFieldValue())}
    TextField(
        modifier = Modifier.fillMaxWidth(),
        value = emailState.value,
        onValueChange = { emailState.value = it},
        label = { Text(text = stringResource(id = R.string.email_hint))},
        colors = TextFieldDefaults.textFieldColors(
            focusedIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent
        ),
        shape = RoundedCornerShape(8.dp),
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email)

    )
}

@Composable
fun Title() {
    Text(
        text = stringResource(id = R.string.sign_in_welcome_text),
        style = MaterialTheme.typography.h1
    )
}
