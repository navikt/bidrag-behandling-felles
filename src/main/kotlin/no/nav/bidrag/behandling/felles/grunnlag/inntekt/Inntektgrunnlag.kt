package no.nav.bidrag.behandling.felles.grunnlag.inntekt

import com.fasterxml.jackson.annotation.JsonFormat
import com.fasterxml.jackson.databind.annotation.JsonDeserialize
import java.time.LocalDate
import java.time.LocalDateTime

@JsonDeserialize(`as` = Inntektgrunnlag::class)
class Inntektgrunnlag(
  val personId: String,
  @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
  val periodeFra: LocalDate,
  @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
  val periodeTil: LocalDate?,
  val aktiv: Boolean,
  val brukFra: LocalDateTime,
  val brukTil: LocalDateTime?,
  val hentetTidspunkt: LocalDateTime,
  val inntektgrunnlagPoster: List<InntektgrunnlagPost>
) :
  IInntektGrunnlag {

}