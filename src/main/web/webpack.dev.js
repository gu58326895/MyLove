var webpack = require('webpack');
var WebpackDevServer = require("webpack-dev-server");

var config = {
  entry: {
    index: './index.js'
  },
  output: {
    path: __dirname,
    filename: 'bundle.js'
  },
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
      }
    ]
  },
  resolve: {
    extensions: ['', '.js'],
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