package com.example.compose_codeblock

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.compose_codeblock.ui.theme.ComposecodeblockTheme
import com.falconwebs.codeblock.core.CodeBlock
import com.falconwebs.codeblock.theme.CodeBlockTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ComposecodeblockTheme {
                Column (
                    modifier = Modifier.fillMaxSize(),
                    verticalArrangement = Arrangement.Center
                ){
                    Box (
                        modifier = Modifier.fillMaxWidth().padding(12.dp),
                    ) {
                        CodeBlock(
                            code = """
                                struct Config  {
                                    pub query: String,
                                    pub file_path: String,
                                    pub ignore_case: bool,
                                }
                                
                                impl Config {
                                    fn build(args: &[String]) -> Result<Config, &'static str> {
                                        if args.len() < 3{
                                            return Err("Not enough arguments");
                                        }
                                        let query = args[1].clone();
                                        let file_path = args[2].clone();
                                
                                        let ignore_case = env::var("IGNORE_CASE").is_ok();
                                
                                        Ok(Config {query, file_path, ignore_case})
                                    }
                                }
                                
                                fn main(){
                                    println!("Hello from @falcon.webs_")
                                }
                            """.trimIndent(),
                            theme = CodeBlockTheme.solarizedDark()
                        )
                    }
                }
            }
        }
    }
}
