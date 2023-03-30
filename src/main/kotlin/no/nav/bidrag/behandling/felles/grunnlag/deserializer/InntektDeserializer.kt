package no.nav.bidrag.behandling.felles.grunnlag.deserializer

import com.fasterxml.jackson.core.JsonParser
import com.fasterxml.jackson.core.JsonProcessingException
import com.fasterxml.jackson.databind.DeserializationContext
import com.fasterxml.jackson.databind.JsonDeserializer
import com.fasterxml.jackson.databind.JsonNode
import no.nav.bidrag.behandling.felles.grunnlag.inntekt.IInntektGrunnlag
import no.nav.bidrag.behandling.felles.grunnlag.inntekt.Inntektgrunnlag
import no.nav.bidrag.behandling.felles.grunnlag.inntekt.Skattegrunnlag

class InntektDeserializer : JsonDeserializer<IInntektGrunnlag?>() {
    override fun deserialize(p0: JsonParser, p1: DeserializationContext?): IInntektGrunnlag? {
        val jsonNode: JsonNode = p0.readValueAsTree()

        val skattegrunnlag = deserializeInntekt(p0, jsonNode, Skattegrunnlag::class.java)
        if (skattegrunnlag != null) {
            return skattegrunnlag
        }
        val inntektgrunnlag = deserializeInntekt(p0, jsonNode, Inntektgrunnlag::class.java)
        if (inntektgrunnlag != null) {
            return inntektgrunnlag
        }
        return null
    }

    private fun <T>deserializeInntekt(jsonParser: JsonParser, jsonNode: JsonNode, clazz: Class<T>): T? {
        return try {
            jsonParser.codec.treeToValue(jsonNode, clazz)
        } catch (e: JsonProcessingException) {
            null
        }
    }
}
