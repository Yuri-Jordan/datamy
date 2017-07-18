 get_fb_dataset <- function(token, page){
  require(Rfacebook)
            data <- as.POSIXct('2014/07/12', tz = 'UTC')
       posts <- getPage(page, token = token, reactions = T, feed = T, since = data)
       
       
       comments <- get_all_comments(posts, token)
       comments <- as.data.frame(comments, stringsAsFactors = F)
       
  return(comments)
  
 }
 
 get_all_comments <- function(posts, token){
       
       novo <- getPost(posts$id[1],token = token,comments = T)
       for(i in 2:nrow(posts)){
             novo <- merge(novo, (getPost(posts$id[i], 
                                          token = token, 
                                          comments = T)), all = T ) 
       }
       novo <- as.data.frame(novo, stringsAsFactors = F)   
       return(novo)
 }

 
# # install.packages("Rfacebook", dependencies = T)
# # install.packages("xlsx", dependencies = T)
# require(Rfacebook)
# require(xlsx)
# 
# token <- ""
# pages <- c("OiOficial",
#            "vivo",
#            "timbrasil",
#            "paodeacucar",
#            "magazineluiza",
#            "CasasBahia",
#            "atacadaodoseletros",
#            "uberbr",
#            "natura.br",
#            "CarrefourBR")
# #pegar p�ginas
# posts <- getPage(pages[1], token = token, n = 10, reactions = T)
# for(i in 2:length(pages)){
#   posts <- merge(posts, getPage(pages[i], token = token, n = 10, reactions = T), all = T)
# }
# 
# #cria coluna com nome da empresa do post
# comments <- getPost(posts$id[1], token = token, n = 5)
# comments <- comments$comments
# comments$empresa <- "NULL"
# for(i in 2:nrow(posts)){
#   print(i)
#   t <- getPost(posts$id[i], token = token, n = 5)
#   p <- t$post$from_name[1]
#   t <- t$comments
#   if(nrow(t) != 0)
#     t$empresa <- p
#   comments <- merge(comments, t, all = T)
# }
# 
# #avaliar manualmente
# comments$avaliacao <- "NULL"
# for(i in 1:nrow(comments)){
#   print(comments$message[i])
#   print("---------------------------------------------------------------------------")
#   print(paste("EMPRESA: ", comments$empresa[i]))
#   opcao <- scan(nmax = 1)
#   if(opcao == 1)
#     comments$avaliacao[i] <- "reclamacao"
#   else if(opcao==2)
#     comments$avaliacao[i] <- "duvida"
#   else if(opcao==3)
#     comments$avaliacao[i] <- "solucao"
#   else
#     comments$avaliacao[i] <- "neutro"
# }
# 
# #exportar como xlsx
# write.xlsx(comments, "C:/Users/teste/Documents/R/comentarios.xlsx")
# write.xlsx(posts, "C:/Users/teste/Documents/R/posts.xlsx")


