private const REDMINE_SERVICE_KEY = "Jp9x075Ce5pGfgz2iKdw" 

Call HTTPPost("http://localhost:3001/redmine/sys/fetch_changesets", "key=" & REDMINE_SERVICE_KEY)

Private Function HTTPPost(sUrl, sRequest)
  set oHTTP = CreateObject("Microsoft.XMLHTTP")
  oHTTP.open "POST", sUrl, false
  oHTTP.setRequestHeader "Content-Type", "application/x-www-form-urlencoded" 
  oHTTP.setRequestHeader "Content-Length", Len(sRequest)
  oHTTP.send sRequest
  HTTPPost = oHTTP.responseText
End Function
