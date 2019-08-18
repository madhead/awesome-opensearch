<?xml version="1.0"?>
<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
                xmlns:opensearch="http://a9.com/-/spec/opensearch/1.1/"
                version="1.0">
	<xsl:output method="html" version="5.0" encoding="UTF-8" indent="yes"/>
	<xsl:template match="/">
		<html lang="en">
			<head>
				<meta charset="UTF-8"/>
				<meta name="viewport" content="width=device-width, initial-scale=1.0"/>
				<link
						rel="search"
						type="application/opensearchdescription+xml"
						href="opensearch.xml">
					<xsl:attribute name="title">
						<xsl:value-of select="./opensearch:OpenSearchDescription/opensearch:ShortName"/>
					</xsl:attribute>
				</link>
				<title>
					<xsl:value-of select="./opensearch:OpenSearchDescription/opensearch:ShortName"/>
				</title>
			</head>
			<body>
				<h1>
					<xsl:value-of select="./opensearch:OpenSearchDescription/opensearch:ShortName"/>
				</h1>
			</body>
		</html>
	</xsl:template>
</xsl:stylesheet>
