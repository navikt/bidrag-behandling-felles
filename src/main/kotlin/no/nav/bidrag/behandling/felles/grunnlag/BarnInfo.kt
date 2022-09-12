package no.nav.bidrag.behandling.felles.grunnlag

class BarnInfo(
  val fnr: String,
  val navn: String,
  val erSoknadsbarn: Boolean,
  val andelForsorget: Double,
  val harSammeAdresseSomBP: Boolean
) : IGrunnlagInnhold {}