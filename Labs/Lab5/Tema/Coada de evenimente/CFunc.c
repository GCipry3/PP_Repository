#include <stdio.h>
#include <stdlib.h>
#include <regex.h>
#include <string.h>
char* readFunc()
{
	FILE* ptr;
	char* string = (char*)malloc(100*sizeof(char));
	char ch;
	int index=0;
	ptr=fopen("inputFromTail.txt","r");
	
	do{
		ch=fgetc(ptr);
		string[index++]=ch;
	}while(ch!=EOF);
	string[index-1]='\0';
	
	return string;
}

int checkWithRegex(char* string)
{
	regex_t re;
	int rc;                         
    //char *pattern = "(( )*(</?html>|</?head>|</?title>|</?p>).*(</?html>|</?head>|</?title>|</?p>))|( )*|(</?html>|</?head>|</?title>|</?p>)";           
	char *pattern = "( )*((</?html>|</?head>|<p>|</?body>)|(<title>.*</title>)|(<h1>.*</h1>)|(<p>.*</p>))";           

	if ((rc = regcomp(&re, pattern, REG_EXTENDED)) != 0) {                    
       printf("regcomp() failed, returning nonzero (%d)\n", rc);  
       exit(1);                                                                 
    }  

	
	if ((rc = regexec(&re, string, 0, NULL, 0)) != 0) 
	{                
    //    printf("failed to ERE match '%s' with '%s',returning %d.\n", string, pattern, rc);
	   return 0;                                                
    } 

	return 1;
}

int main()
{
	char* aux=readFunc();
	printf("=============================\n%s\n",aux);
	char* test=(char*)malloc(10);
	if(checkWithRegex(aux))
		strcpy(test,"ok");
	else
		strcpy(test,"not ok");
	printf("This line is :%s\n=============================\n",test);

	return 0;
}
