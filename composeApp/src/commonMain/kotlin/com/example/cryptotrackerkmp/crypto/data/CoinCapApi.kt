package com.example.cryptotrackerkmp.crypto.data

import com.example.cryptotrackerkmp.core.data.networking.createHttpClient
import com.example.cryptotrackerkmp.core.domain.util.Resource1
import io.ktor.client.call.body
import io.ktor.client.plugins.ClientRequestException
import io.ktor.client.plugins.ServerResponseException
import io.ktor.client.request.get
import io.ktor.client.statement.request
import io.ktor.http.HttpHeaders
import io.ktor.http.headers

class CoinCapApi {

    private val client = createHttpClient()
    private val baseUrl = "https://api.coincap.io/v2"
    private val apiKey = "e3a4b6b084dabb88681210604a9af8d8256319372301503f448a4ff16df156b0"


    suspend fun getAssets(): Resource1<CryptoAssetsDto> {
        return try {
            val response = client.get("${baseUrl}assets") {
                headers {
//                    append("accept", "application/json")
//                    append("Authorization", "Bearer $apiKey")

                }
            }

            println("➡️ API URL: ${response.request.url}")
            println("⬅️ API STATUS: ${response.status}")
            println("⬅️ API CONTENT-TYPE: ${response.headers[HttpHeaders.ContentType]}")
            println("➡️ API URL: ${response}")


            Resource1.Success(response.body())

        } catch (e: ClientRequestException) {
            Resource1.Error(e.message ?: "Client error", e.response.status.value)
        } catch (e: ServerResponseException) {
            Resource1.Error(e.message ?: "Server error", e.response.status.value)
        } catch (e: Exception) {
            Resource1.Error(e.message ?: "Unknown error")
        }
    }
}