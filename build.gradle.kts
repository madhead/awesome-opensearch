import com.github.eerohele.SaxonXsltTask

plugins {
    id("com.github.eerohele.saxon-gradle").version("0.8.0")
}

tasks {
    xslt {
        enabled = false
    }

    register<Delete>("clean") {
        delete(project.buildDir)
    }

    create("awesome-opensearch").apply {
        fileTree(
                "dir" to "src/opensearch",
                "include" to "**/opensearch.xml"
        ).forEach { openSearchXml ->
            val xslt = register<SaxonXsltTask>(
                    "Process ${openSearchXml.toRelativeString(project.file("src/opensearch")).replace(File.separator, "-")}"
            ) {
                stylesheet("src/xslt/stylesheet.xsl")
                input(openSearchXml)
                output(File(File(project.buildDir, openSearchXml.parentFile.toRelativeString(project.file("src/opensearch"))), "index.html"))
            }
            val copy = register<Copy>(
                    "Copy ${openSearchXml.toRelativeString(project.file("src/opensearch")).replace(File.separator, "-")}"
            ) {
                from(openSearchXml)
                into(File(project.buildDir, openSearchXml.parentFile.toRelativeString(project.file("src/opensearch"))))
            }

            dependsOn(xslt)
            dependsOn(copy)
        }
    }
}
