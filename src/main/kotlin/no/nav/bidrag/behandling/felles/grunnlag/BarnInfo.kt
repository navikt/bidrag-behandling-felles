package no.nav.bidrag.behandling.felles.grunnlag

import java.time.LocalDate

class BarnInfo(
  val datoFom: LocalDate,
  val datoTil: LocalDate?,
  val fnr: String,
  val navn: String,
  val erSoknadsbarn: Boolean,
  val andelForsorget: Double,
  val harSammeAdresseSomBP: Boolean
) : IGrunnlagInnhold {}