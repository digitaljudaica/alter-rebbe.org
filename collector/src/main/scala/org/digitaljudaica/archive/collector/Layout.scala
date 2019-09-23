package org.digitaljudaica.archive.collector

import java.io.File

final class Layout(docs: File) {

  private def docs(fileName: String): File = new File(docs, fileName)

  val indexMd: File = docs("index.md")

  val configYml: File = docs("_config.yml")

  // Note: also hard-coded in _layouts/tei.html (for 'names') and in 'index.md'!
  private val collectionsDirectoryName: String = "collections"

  val collections: File = docs(collectionsDirectoryName)

  def collections(name: String): File = new File(collections, name)

  val collectionsFileName: String = "collections"

  private def url(ref: String): String = s"/$collectionsDirectoryName/$ref"

  val namesDirectoryName: String = "names"

  val namesDirectory: File = docs(namesDirectoryName)

  val namesFileDirectory: File = docs

  val namesFileName: String = "names"

  val namesUrl: String = s"/$namesFileName.html"

  val collectionFileName: String = "collection"

  def collectionUrl(name: String): String = url(s"$name/index.html")

  // Note: also hard-coded in _layouts/facsimile.html!
  private val facsimilesDirectoryName: String = "facsimiles"

  def facsimiles(collectionDirectory: File): File = new File(collectionDirectory, facsimilesDirectoryName)

  // Note: also hard-coded in _layouts/tei.html!
  val facsDirectoryName: String = "facs" // facsimile viewers

  def facs(collectionDirectory: File): File = new File(collectionDirectory, facsDirectoryName)

  val teiDirectoryName: String = "tei"

  def tei(collectionDirectory: File): File = new File(collectionDirectory, teiDirectoryName)

  // Note: also hard-coded in _layouts/facsimile.html!
  val docsDirectoryName: String = "documents" // wrappers for TEI XML

  def docs(collectionDirectory: File): File = new File(collectionDirectory, docsDirectoryName)

  def documentUrl(collectionDirectoryName: String, name: String): String =
    url(s"$collectionDirectoryName/${documentUrlRelativeToIndex(name)}")

  def documentUrlRelativeToIndex(name: String): String =  s"$docsDirectoryName/$name.html"
}
