package no.nav.bidrag.behandling.felles.grunnlag.inntekt

import com.fasterxml.jackson.databind.annotation.JsonDeserialize
import no.nav.bidrag.behandling.felles.grunnlag.deserializer.InntektDeserializer

@JsonDeserialize(using = InntektDeserializer::class)
interface IInntektGrunnlag {
}