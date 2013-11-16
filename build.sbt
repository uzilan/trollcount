

name := "trollcount"

// Add dependencies on jUnit and Specs2
libraryDependencies ++= Seq(
  "org.specs2" %% "specs2" % "2.3.3" % "test",
  "junit" % "junit" % "4.8.2" % "test"
)

// Set the Scaladoc title
scalacOptions in (Compile, doc) ++= Opts.doc.title("Trollcount API")

// Add source links in Scaladoc
scalacOptions in (Compile, doc) <++= baseDirectory.map {
      (bd: File) => Seq[String](
         "-sourcepath", bd.getAbsolutePath,
         "-doc-source-url",
         "https://github.com/uzilan/trollcount/tree/master€{FILE_PATH}.scala"
      )
    }
