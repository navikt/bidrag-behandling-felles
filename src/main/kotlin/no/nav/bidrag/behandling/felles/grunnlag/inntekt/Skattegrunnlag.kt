package no.nav.bidrag.behandling.felles.grunnlag.inntekt

import com.fasterxml.jackson.databind.annotation.JsonDeserialize

@JsonDeserialize(`as` = Skattegrunnlag::class)
class Skattegrunnlag(val personId: String, val aar: Int, val inntektsposter: List<SkattegrunnlagPost>) :
    IInntektGrunnlag
