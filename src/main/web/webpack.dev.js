var webpack = require('webpack');
var WebpackDevServer = require("webpack-dev-server");
var ExtractTextPlugin = require("extract-text-webpack-plugin");

var config = {
  entry: {
    index: './index.js'
  },
  output: {
    path: __dirname,
    filename: 'bundle.js'
  },
  plugins: [
    new ExtractTextPlugin('myLove.css')
  ],
  devtool: 'source-map',
  module: {
    loaders: [
      {
        test: /\.js$/,
        exclude: /node_modules/,
        loader: 'babel-loader',
        query: {
          presets: ['es2015']
        }
      },
      {
        test: /\.html$/,
        loader: 'html'
      },
      {
        test: /\.css$/,
        loader: ExtractTextPlugin.extract("style-loader", "css-loader")
      }
    ]
  },
  resolve: {
    extensions: ['', '.js', '.html', '.css'],
    root: __dirname,
    alias: {

    }
  }
};

var compiler = webpack(config);
var server = new WebpackDevServer(compiler, {
  hot: true,
  quiet: true,
  proxy: {
    '/service/*': {
      target: 'http://localhost:8081',
      secure: false
    }
  }
});
server.listen(8080);