package com.prabhat.code_piler.ui.theme.components

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview


import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.toSize
import com.prabhat.code_piler.R
import com.prabhat.code_piler.ui.theme.Theme


// Creating a composable
// function to display Top Bar
@Composable
fun MainContent() {
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        "Code-Piler",
                        color = Color.White
                    )
                },
                backgroundColor = Theme
            )
        },
        content = { MyContent() }
    )
}

// Creating a composable function
// to create an Outlined Text Field
// Calling this function as content
// in the above function
@Composable
fun MyContent() {

    // Declaring a boolean value to store
    // the expanded state of the Text Field
    var mExpanded by remember { mutableStateOf(false) }

    // Create a list of cities
    val mCities = listOf(" ", "C", "C++", "Java", "Python")

    // Create a string value to store the selected city
    var mSelectedText by remember { mutableStateOf("") }

    var mTextFieldSize by remember { mutableStateOf(Size.Zero) }

    val selectedItem= remember {
        mutableStateOf(mCities[0])


    }
    // Define a map of images for each item in the dropdown
    val itemToImageMap = mapOf(
        " " to R.drawable.default_language,
        "C" to R.drawable.c_icn,
        "C++" to R.drawable.cpp_icn,
        "Java" to R.drawable.java_icn,
        "Python" to R.drawable.python_icn

    )
    // Get the current image for the selected item
    val currentImage = itemToImageMap[selectedItem.value]


    // Up Icon when expanded and down icon when collapsed
    val icon = if (mExpanded)
        Icons.Filled.KeyboardArrowUp
    else
        Icons.Filled.KeyboardArrowDown

    Row(
        modifier = Modifier
            .padding(20.dp)

    ) {

        Image(
            painter = painterResource(
                id = currentImage ?: R.drawable.default_language
            ),
            contentDescription = "Language Icon",
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .size(70.dp)
                .padding(5.dp)
        )




        // Create an Outlined Text Field
        // with icon and not expanded
        OutlinedTextField(
            value = mSelectedText,
            onValueChange = { mSelectedText = it },
            modifier = Modifier
                .fillMaxWidth()
                .onGloballyPositioned { coordinates ->
                    // This value is used to assign to
                    // the DropDown the same width
                    mTextFieldSize = coordinates.size.toSize()
                },
            label = { Text("Select Language") },
            trailingIcon = {
                Icon(icon, "contentDescription",
                    Modifier.clickable { mExpanded = !mExpanded })
            }
        )

        // Create a drop-down menu with list of cities,
        // when clicked, set the Text Field text as the city selected
        DropdownMenu(
            expanded = mExpanded,
            onDismissRequest = { mExpanded = false },
            modifier = Modifier
                .width(with(LocalDensity.current) { mTextFieldSize.width.toDp() })
        ) {
            mCities.forEach { label ->
                DropdownMenuItem(onClick = {
                    //mSelectedText = label
                    selectedItem.value=label
                    mExpanded = false
                }) {
                    //Text(text = label)
                    Text(label)
                }
            }
        }
    }
}
@Composable
fun DropdownWithImage() {
    // Define a list of items for the dropdown menu
    val items = listOf("C", "C++", "Java", "Python")

    // Define a mutable state to hold the selected item
    val selectedItem = remember { mutableStateOf(items[0]) }

    // Define a map of images for each item in the dropdown
    val itemToImageMap = mapOf(
        "C" to R.drawable.c_icn,
        "C++" to R.drawable.cpp_icn,
        "Java" to R.drawable.java_icn,
        "Python" to R.drawable.python_icn
    )

    // Get the current image for the selected item
    val currentImage = itemToImageMap[selectedItem.value]

    // Create the dropdown menu
    DropdownMenu(
        expanded = false,
        onDismissRequest = { },
    ) {
        items.forEach { item ->
            DropdownMenuItem(onClick = {
                selectedItem.value = item
            }) {
                Text(item)
            }
        }
    }

    // Display the image for the selected item
    Image(
        painter = painterResource(id = currentImage ?: R.drawable.default_language),
        contentDescription = "Image for selected item"
    )
}



@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    MainContent()
}