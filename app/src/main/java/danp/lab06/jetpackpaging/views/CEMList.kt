package danp.lab06.jetpackpaging.views

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.paging.LoadState
import androidx.paging.compose.collectAsLazyPagingItems
import androidx.paging.compose.items
import coil.compose.AsyncImagePainter
import coil.compose.rememberAsyncImagePainter
import danp.lab06.jetpackpaging.CemViewModel
import danp.lab06.jetpackpaging.model.CEM

@Composable
fun CEMList(viewModel: CemViewModel = hiltViewModel()) {
    val res = viewModel.pager.collectAsLazyPagingItems()

    LazyColumn {
        items(res) { data ->
            CardCEM(data)
        }
        res.apply {
            when{
                loadState.refresh is LoadState.Loading ->{
                    item{
                        Box(modifier = Modifier
                            .fillMaxSize()
                            .padding(16.dp)) {
                            CircularProgressIndicator(modifier = Modifier
                                .padding(12.dp)
                                .align(Alignment.Center))
                        }
                    }
                }

                loadState.append is LoadState.Loading ->{
                    item{
                        Box(modifier = Modifier
                            .fillMaxWidth()
                            .padding(16.dp)) {
                            CircularProgressIndicator(modifier = Modifier
                                .padding(12.dp)
                                .align(Alignment.Center))
                        }
                    }
                }

                loadState.prepend is LoadState.Loading ->{
                    item{
                        Box(modifier = Modifier
                            .fillMaxWidth()
                            .padding(16.dp)) {
                            CircularProgressIndicator(modifier = Modifier
                                .padding(12.dp)
                                .align(Alignment.Center))
                        }
                    }
                }

            }
        }

    }

}

@Composable
fun CardCEM(cn: CEM?) {
    Surface(shape = RoundedCornerShape(8.dp),
        elevation = 8.dp,
        modifier = Modifier.padding(8.dp)) {
        Column(modifier = Modifier.padding(16.dp),
        ) {
            val modifier = Modifier
                .height(150.dp)
                .fillMaxWidth()
                .clip(shape = RoundedCornerShape(8.dp))
            val painter = rememberAsyncImagePainter(model = cn?.image)
            val estado = painter.state
            Image(painter = painter,
                contentDescription =null,
                modifier = modifier,
                contentScale = ContentScale.Crop
            )
            if(estado is AsyncImagePainter.State.Loading){
                CircularProgressIndicator()
            }
            Spacer(modifier = Modifier.height(16.dp))
            Row(modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceEvenly) {
                Column() {
                    Text(
                        buildAnnotatedString {
                            withStyle(style = SpanStyle(fontWeight = FontWeight.Bold,color = Color.Black)) {
                                append("NOMBRE : ")
                            }

                            append("CEM "+cn?.nombre.toString())

                        }
                        ,color = Color.Black,style = MaterialTheme.typography.h6
                    )
                    Text(
                        buildAnnotatedString {
                            withStyle(style = SpanStyle(fontWeight = FontWeight.Bold,color = Color.Black)) {
                                append("DEPARTAMENTO: ")
                            }
                            append(cn?.departamento.toString())
                        }
                        ,color = Color.Black,style = MaterialTheme.typography.h6
                    )
                    Text(
                        buildAnnotatedString {
                            withStyle(style = SpanStyle(fontWeight = FontWeight.Bold,color = Color.Black)) {
                                append("PROVINCIA: ")
                            }
                            append(cn?.provincia.toString())
                        }
                        ,color = Color.Black,style = MaterialTheme.typography.h6
                    )
                    Text(
                        buildAnnotatedString {
                            withStyle(style = SpanStyle(fontWeight = FontWeight.Bold,color = Color.Black)) {
                                append("DISTRITO: ")
                            }
                            append(cn?.distrito.toString())
                        }
                        ,color = Color.Black,style = MaterialTheme.typography.h6
                    )
                    Text(
                        buildAnnotatedString {
                            withStyle(style = SpanStyle(fontWeight = FontWeight.Bold,color = Color.Black)) {
                                append("DIRECCION: ")
                            }
                            append(cn?.direccion .toString())
                        }
                        ,color = Color.Black,style = MaterialTheme.typography.h6
                    )
                    Text(
                        buildAnnotatedString {
                            withStyle(style = SpanStyle(fontWeight = FontWeight.Bold,color = Color.Black)) {
                                append("COORDINADOR: ")
                            }
                            append(cn?.coordinador.toString())
                        }
                        ,color = Color.Black,style = MaterialTheme.typography.h6
                    )
                    Text(
                        buildAnnotatedString {
                            withStyle(style = SpanStyle(fontWeight = FontWeight.Bold,color = Color.Black)) {
                                append("TELEFONO: ")
                            }
                            append(cn?.telefono.toString())
                        }
                        ,color = Color.Black,style = MaterialTheme.typography.h6
                    )
                    Text(
                        buildAnnotatedString {
                            withStyle(style = SpanStyle(fontWeight = FontWeight.Bold,color = Color.Black)) {
                                append("TIPO: ")
                            }
                            append(cn?.tipo.toString())
                        }
                        ,color = Color.Black,style = MaterialTheme.typography.h6
                    )
                }
            }
        }
    }

}

