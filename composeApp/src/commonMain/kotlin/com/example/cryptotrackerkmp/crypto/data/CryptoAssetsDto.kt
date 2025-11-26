package com.example.cryptotrackerkmp.crypto.data

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable


@Serializable
data class CryptoAssetsDto(

	@SerialName("data")
	val data: List<DataItem?>? = null,

	@SerialName("timestamp")
	val timestamp: Long? = null
)

@Serializable
data class DataItem(

	@SerialName("symbol")
	val symbol: String? = null,

	@SerialName("volumeUsd24Hr")
	val volumeUsd24Hr: String? = null,

	@SerialName("priceUsd")
	val priceUsd: String? = null,

	@SerialName("vwap24Hr")
	val vwap24Hr: String? = null,

	@SerialName("supply")
	val supply: String? = null,

	@SerialName("marketCapUsd")
	val marketCapUsd: String? = null,

	@SerialName("changePercent24Hr")
	val changePercent24Hr: String? = null,

	@SerialName("name")
	val name: String? = null,

	@SerialName("explorer")
	val explorer: String? = null,

	@SerialName("rank")
	val rank: String? = null,

	@SerialName("tokens")
	val tokens: Tokens? = null,

	@SerialName("id")
	val id: String? = null,

	@SerialName("maxSupply")
	val maxSupply: String? = null
)

@Serializable
data class Tokens(

	@SerialName("10")
	val jsonMember10: List<String?>? = null,

	@SerialName("56")
	val jsonMember56: List<String?>? = null,

	@SerialName("1")
	val jsonMember1: List<String?>? = null,

	@SerialName("137")
	val jsonMember137: List<String?>? = null,

	@SerialName("99")
	val jsonMember99: List<String?>? = null,

	@SerialName("8453")
	val jsonMember8453: List<String?>? = null,

	@SerialName("101")
	val jsonMember101: List<String?>? = null,

	@SerialName("42161")
	val jsonMember42161: List<String?>? = null,

	@SerialName("1600")
	val jsonMember1600: List<String?>? = null,

	@SerialName("43114")
	val jsonMember43114: List<String?>? = null,

	@SerialName("480")
	val jsonMember480: List<String?>? = null,

	@SerialName("130")
	val jsonMember130: List<String?>? = null
)
